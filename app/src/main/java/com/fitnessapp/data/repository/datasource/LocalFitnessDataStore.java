package com.fitnessapp.data.repository.datasource;


import com.fitnessapp.app.App;
import com.fitnessapp.data.datautils.IntToStepMapper;
import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by carriagecompany on 8/6/17.
 */

public class LocalFitnessDataStore implements FitnessDataStore {

    @Override
    public void saveStepCount(int stepCount) {
        App.getFitnessLocalDataBase().stepDAO().insert(IntToStepMapper.createStep(stepCount));
    }

    @Override
    public Flowable<List<StepEntity>> getTotalStepCount() {
        return App.getFitnessLocalDataBase().stepDAO().getAllSteps();
    }

    @Override
    public void resetTotalCount() {
        App.getFitnessLocalDataBase().stepDAO().resetCounter();
    }

    @Override
    public DiscountEntity getAvailableDiscount(int stepCount) {
        return null;
    }
}
