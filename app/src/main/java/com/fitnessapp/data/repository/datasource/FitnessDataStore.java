package com.fitnessapp.data.repository.datasource;



import com.fitnessapp.data.model.DiscountEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by carriagecompany on 8/6/17.
 */

public interface FitnessDataStore {

    void saveStepCount(int stepCount);

    int getTotalStepCount();

    void resetTotalCount();

    DiscountEntity getAvailableDiscount(int stepCount);

}
