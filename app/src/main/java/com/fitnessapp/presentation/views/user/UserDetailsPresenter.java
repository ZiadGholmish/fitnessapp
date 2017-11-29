package com.fitnessapp.presentation.views.user;

import android.util.Log;

import com.fitnessapp.app.AbsPresenter;
import com.fitnessapp.app.App;
import com.fitnessapp.app.AppConstants;
import com.fitnessapp.domain.interactors.DefaultObserver;
import com.fitnessapp.domain.interactors.usecases.FetchAllStepCountsUseCase;
import com.fitnessapp.domain.interactors.usecases.FetchAppSettingsUseCase;
import com.fitnessapp.domain.interactors.usecases.ResetTotalStepCountUseCase;
import com.fitnessapp.domain.interactors.usecases.SaveAppSettingsUseCase;
import com.fitnessapp.domain.interactors.usecases.SaveStepCountUseCase;
import com.fitnessapp.domain.model.AppSettingsModel;
import com.fitnessapp.domain.model.StepModel;
import com.fitnessapp.presentation.views.home.HomeContract;
import com.fitnessapp.presentation.views.home.HomePresenter;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by carriagecompany on 11/13/17.
 */

public class UserDetailsPresenter extends AbsPresenter<UserDetailsContract.View> implements UserDetailsContract.Actions {

    private FetchAppSettingsUseCase fetchAppSettingsUseCase;
    private SaveAppSettingsUseCase saveAppSettingsUseCase;

    @Inject
    public UserDetailsPresenter(SaveAppSettingsUseCase saveAppSettingsUseCase,
                                FetchAppSettingsUseCase fetchAppSettingsUseCase) {
        this.fetchAppSettingsUseCase = fetchAppSettingsUseCase;
        this.saveAppSettingsUseCase = saveAppSettingsUseCase;
    }


    @Override
    public void saveUserSettings(String fullName, int age, int weight, int height, int gender) {

        AppSettingsModel appSettingsModel = createAppSettingsModel(fullName, age, weight, height, gender);
        saveAppSettingsUseCase.execute(new UserDetailsPresenter.SaveAppSettings(),
                SaveAppSettingsUseCase.Params.forSaveAppSettings(appSettingsModel));

    }

    @Override
    public void checkAppSettings() {
        fetchAppSettingsUseCase.execute(new UserDetailsPresenter.GetAppSettings(), null);
    }

    private AppSettingsModel createAppSettingsModel(String fullName, int age, int weight, int height, int gender) {
        AppSettingsModel appSettingsModel = new AppSettingsModel();
        appSettingsModel.setFullName(fullName);
        appSettingsModel.setUserAge(age);
        appSettingsModel.setUserWeight(weight);
        appSettingsModel.setHeight(height);
        appSettingsModel.setGender(gender);
        appSettingsModel.setCaloriesFactor(0.5);
        return appSettingsModel;
    }

    private final class SaveAppSettings extends DefaultObserver<Void> {

        @Override
        public void onNext(Void aVoid) {
            super.onNext(aVoid);
            checkAppSettings();
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
            exception.printStackTrace();
            mView.showError("");
        }
    }


    private final class GetAppSettings extends DefaultObserver<AppSettingsModel> {

        @Override
        public void onNext(AppSettingsModel appSettingsModel) {
            super.onNext(appSettingsModel);
            App.setAppSettingsModel(appSettingsModel);
            mView.openTrackScreen();
            mView.closeScreen();
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
            exception.printStackTrace();
            mView.showError("");
        }
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
