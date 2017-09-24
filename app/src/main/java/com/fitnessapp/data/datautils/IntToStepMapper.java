package com.fitnessapp.data.datautils;

import com.fitnessapp.data.model.StepEntity;

/**
 * Created by carriagecompany on 9/24/17.
 */

public class IntToStepMapper {

    public static StepEntity createStep(int count) {

        StepEntity stepEntity = new StepEntity();
        stepEntity.setStepCount(count);
        stepEntity.setDate(System.currentTimeMillis());
        return stepEntity;
    }
}
