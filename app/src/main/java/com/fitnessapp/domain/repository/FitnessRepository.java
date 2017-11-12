package com.fitnessapp.domain.repository;


import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.model.AppSettingsModel;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.domain.model.StepModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by carriagecompany on 8/7/17.
 */

public interface FitnessRepository {

    void saveStepCount(int stepCount);

    Flowable<List<StepModel>> getTotalStepCount();

    void resetTotalCount();

    Flowable<List<DiscountModel>> getAvailableDiscount(int stepCount);

    Flowable<List<DiscountModel>> getAllDiscounts();

    void saveDiscount(DiscountModel discountModel);

    Flowable<AppSettingsModel> getAppSettings();

    void saveAppSetting(AppSettingsModel appSettingsModel);
}
