package com.fitnessapp.data.repository.datasource;


import com.fitnessapp.data.model.DiscountEntity;

/**
 * Created by carriagecompany on 8/6/17.
 */

public class LocalFitnessDataStore implements FitnessDataStore {

    @Override
    public void saveStepCount(int stepCount) {
    }

    @Override
    public int getTotalStepCount() {
        return 0;
    }

    @Override
    public void resetTotalCount() {

    }

    @Override
    public DiscountEntity getAvailableDiscount(int stepCount) {
        return null;
    }
}
