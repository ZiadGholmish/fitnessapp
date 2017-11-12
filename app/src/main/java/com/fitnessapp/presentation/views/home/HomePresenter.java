package com.fitnessapp.presentation.views.home;

import android.app.Activity;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.fitnessapp.R;
import com.fitnessapp.app.AbsPresenter;
import com.fitnessapp.app.App;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.interactors.DefaultObserver;
import com.fitnessapp.domain.interactors.usecases.FetchAllStepCounts;
import com.fitnessapp.domain.interactors.usecases.ResetTotalStepCountUseCase;
import com.fitnessapp.domain.interactors.usecases.SaveStepCountUseCase;
import com.fitnessapp.utils.ResourcesUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Created by carriagecompany on 8/28/17.
 */

public class HomePresenter extends AbsPresenter<HomeContract.View> implements HomeContract.Actions, OnDataPointListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static final int REQUEST_OAUTH = 1;

    private GoogleApiClient mApiClient;

    private SaveStepCountUseCase saveStepCountUseCase;

    private FetchAllStepCounts fetchAllStepCounts;

    private ResetTotalStepCountUseCase resetTotalStepCountUseCase;

    @Inject
    public HomePresenter(SaveStepCountUseCase saveStepCountUseCase,
                         FetchAllStepCounts fetchAllStepCounts,
                         ResetTotalStepCountUseCase resetTotalStepCountUseCase) {
        this.saveStepCountUseCase = saveStepCountUseCase;
        this.fetchAllStepCounts = fetchAllStepCounts;
        this.resetTotalStepCountUseCase = resetTotalStepCountUseCase;

    }

    @Override
    public void setupGoogleClient() {
        mApiClient = new GoogleApiClient.Builder((Activity) mView)
                .addApi(Fitness.SENSORS_API)
                .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    @Override
    public void connectToGoogle() {
        mApiClient.connect();
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        try {
            connectionResult.startResolutionForResult((Activity) mView, REQUEST_OAUTH);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataPoint(DataPoint dataPoint) {

        for (final Field field : dataPoint.getDataType().getFields()) {
            final Value value = dataPoint.getValue(field);
            saveStepCount(Integer.parseInt(value.toString()));
        }
    }


    @Override
    public void onConnected(Bundle bundle) {
        setUpCountStepSensor();
    }

    private void setUpCountStepSensor() {

        SensorRequest sensorRequest = new SensorRequest.Builder()
                .setDataType(DataType.TYPE_STEP_COUNT_DELTA)
                .setSamplingRate(1, TimeUnit.SECONDS)
                .build();
        PendingResult<Status> regResult = Fitness.SensorsApi.add(mApiClient, sensorRequest, this);
        regResult.setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                Log.e("GoogleFit", "count listener registered");
                fetchAllStepCounts.execute(new HomePresenter.GetAllStepsCount(), null);
            }
        });
    }


    @Override
    public void destroy() {
        Fitness.SensorsApi.remove(mApiClient, this)
                .setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        if (status.isSuccess()) {
                            mApiClient.disconnect();
                        }
                    }
                });
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }


    public GoogleApiClient getmApiClient() {
        return mApiClient;
    }


    void saveStepCount(int stepCount) {
        saveStepCountUseCase.execute(new HomePresenter.SaveStepCount(),
                SaveStepCountUseCase.Params.forSaveStep(stepCount));
    }

    private final class SaveStepCount extends DefaultObserver<Void> {

        @Override
        public void onNext(Void aVoid) {
            super.onNext(aVoid);
            fetchAllStepCounts.execute(new HomePresenter.GetAllStepsCount(), null);
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }


    private final class ResetTotalCount extends DefaultObserver<Void> {

        @Override
        public void onNext(Void aVoid) {
            super.onNext(aVoid);
            mApiClient.disconnect();
            mView.showDiscounts();
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }


    private final class GetAllStepsCount extends DefaultObserver<List<StepEntity>> {

        @Override
        public void onNext(List<StepEntity> stepEntities) {
            super.onNext(stepEntities);

            mView.showStepsCount(String.format(ResourcesUtil.getString(R.string.step_place_holder),
                    getTotalSummation(stepEntities) + ""));
            mView.applyProgress((float) (getTotalSummation(stepEntities)) / 100);

            if (getTotalSummation(stepEntities) > 100) {
                resetTotalStepCountUseCase.execute(new HomePresenter.ResetTotalCount(), null);
            }
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }

    private long getTotalSummation(List<StepEntity> stepEntities) {

        long total = 0;
        for (StepEntity stepEntity : stepEntities) {
            total += stepEntity.getStepCount();
        }
        return total;
    }
}
