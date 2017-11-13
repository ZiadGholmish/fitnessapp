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
            appSettingsModel.setHeight(appSettingsEntity.getHeight());
            appSettingsModel.setGender(appSettingsEntity.getGender());

        }
        return appSettingsModel;
    }


    /**
     * Transform a {@link AppSettingsModel} into an {@link AppSettingsEntity}.
     *
     * @param appSettingsModel Object to be transformed.
     * @return {@link AppSettingsEntity} if valid {@link AppSettingsModel} otherwise null.
     */
    public AppSettingsEntity transform(AppSettingsModel appSettingsModel) {

        AppSettingsEntity appSettingsEntity = null;

        if (appSettingsModel != null) {
            appSettingsEntity = new AppSettingsEntity();
            appSettingsEntity.setUserAge(appSettingsModel.getUserAge());
            appSettingsEntity.setCaloriesFactor(appSettingsModel.getCaloriesFactor());
            appSettingsEntity.setUserWeight(appSettingsModel.getUserWeight());
            appSettingsEntity.setGender(appSettingsModel.getGender());
            appSettingsEntity.setHeight(appSettingsModel.getHeight());

        }
        return appSettingsEntity;
    }
    
}
