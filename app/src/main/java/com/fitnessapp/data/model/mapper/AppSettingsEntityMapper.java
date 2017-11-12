package com.fitnessapp.data.model.mapper;

import com.fitnessapp.data.model.AppSettingsEntity;
import com.fitnessapp.domain.model.AppSettingsModel;

import javax.inject.Inject;

/**
 * Created by carriagecompany on 11/12/17.
 */

public class AppSettingsEntityMapper {

    @Inject
    public AppSettingsEntityMapper() {
    }

    /**
     * Transform a {@link AppSettingsEntity} into an {@link AppSettingsModel}.
     *
     * @param appSettingsEntity Object to be transformed.
     * @return {@link AppSettingsModel} if valid {@link AppSettingsEntity} otherwise null.
     */
    public AppSettingsModel transform(AppSettingsEntity appSettingsEntity) {

        AppSettingsModel appSettingsModel = null;

        if (appSettingsEntity != null) {
            appSettingsModel = new AppSettingsModel();
            appSettingsModel.setUserAge(appSettingsEntity.getUserAge());
            appSettingsModel.setCaloriesFactor(appSettingsEntity.getCaloriesFactor());
            appSettingsModel.setUserWeight(appSettingsEntity.getUserWeight());

        }
        return appSettingsModel;
    }
}
