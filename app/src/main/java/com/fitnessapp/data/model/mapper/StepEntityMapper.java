package com.fitnessapp.data.model.mapper;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.model.StepModel;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by carriagecompany on 8/29/17.
 */

@Singleton
public class StepEntityMapper {


    @Inject
    public StepEntityMapper() {
    }

    /**
     * Transform a {@link StepEntity} into an {@link StepModel}.
     *
     * @param stepEntity Object to be transformed.
     * @return {@link DiscountModel} if valid {@link DiscountEntity} otherwise null.
     */
    public StepModel transform(StepEntity stepEntity) {

        StepModel stepModel = null;

        if (stepEntity != null) {

            stepModel = new StepModel();
            stepModel.setStepCount(stepEntity.getStepCount());

        }
        return stepModel;
    }

}
