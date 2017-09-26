package com.fitnessapp.data.repository.datasource;


import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by carriagecompany on 8/6/17.
 */

public interface FitnessDataStore {

    void saveStepCount(int stepCount);

    Flowable<List<StepEntity>> getTotalStepCount();

    void resetTotalCount();

    Flowable<List<DiscountEntity>> getAvailableDiscounts(int stepCount);

    Flowable<List<DiscountEntity>> getAllDiscounts();

    void saveDiscount(DiscountEntity discountEntity);

}
