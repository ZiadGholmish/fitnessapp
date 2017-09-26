package com.fitnessapp.presentation.views.home;

import android.app.Activity;
import android.content.IntentSender;
import android.hardware.Sensor;
import android.os.Bundle;
import android.service.carrier.CarrierMessagingService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.fitnessapp.R;
import com.fitnessapp.app.AbsPresenter;
import com.fitnessapp.app.App;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.interactors.DefaultObserver;
import com.fitnessapp.domain.interactors.usecases.FetchAllStepCounts;
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
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

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

    @Inject
    public HomePresenter(SaveStepCountUseCase saveStepCountUseCase,
                         FetchAllStepCounts fetchAllStepCounts) {
        this.saveStepCountUseCase = saveStepCountUseCase;
        this.fetchAllStepCounts = fetchAllStepCounts;

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
            Log.e("the step count is ", value.toString());
            saveStepCount(Integer.parseInt(value.toString()));
        }
    }


    void saveStepCount(int stepCount) {
        saveStepCountUseCase.execute(new HomePresenter.SaveStepCount(),
                SaveStepCountUseCase.Params.forSaveStep(stepCount));
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

    private void registerFitnessDataListener(DataSource dataSource, DataType dataType) {

        SensorRequest request = new SensorRequest.Builder()
                .setDataSource(dataSource)
                .setDataType(dataType)
                .setSamplingRate(1, TimeUnit.SECONDS)
                .build();

        Fitness.SensorsApi.add(mApiClient, request, this)
                .setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        if (status.isSuccess()) {
                            //  Log.e("GoogleFit", "SensorApi successfully added");
                        }
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

    private final class SaveStepCount extends DefaultObserver<Void> {

        @Override
        public void onNext(Void aVoid) {
            super.onNext(aVoid);
            Toast.makeText(App.getContext(), "Done Saving point", Toast.LENGTH_LONG).show();
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


    private final class GetAllStepsCount extends DefaultObserver<List<StepEntity>> {

        @Override
        public void onNext(List<StepEntity> stepEntities) {
            super.onNext(stepEntities);

            mView.showStepsCount(String.format(ResourcesUtil.getString(R.string.step_place_holder),
                    getTotalSummtion(stepEntities) + ""));
            mView.applyProgress((float) (getTotalSummtion(stepEntities)) / 100);

            if (getTotalSummtion(stepEntities) > 100) {
                mApiClient.disconnect();

                mView.showStepsCount("Congrats\nYou deserve it :D ");

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


    private long getTotalSummtion(List<StepEntity> stepEntities) {

        long total = 0;
        for (StepEntity stepEntity : stepEntities) {
            total += stepEntity.getStepCount();
        }
        return total;
    }
}
