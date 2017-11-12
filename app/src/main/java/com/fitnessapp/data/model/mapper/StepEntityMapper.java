package com.fitnessapp.data.model.mapper;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.model.StepModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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


    /**
     * Transform a List of {@link StepEntity} into a Collection of {@link StepModel}.
     *
     * @param stepEntityCollection Object Collection to be transformed.
     * @return {@link StepModel} if valid {@link StepEntity} otherwise null.
     */
    public List<StepModel> transform(Collection<StepEntity> stepEntityCollection) {

        final List<StepModel> stepModels = new ArrayList<>();

        if (stepEntityCollection != null) {

            for (StepEntity stepEntity : stepEntityCollection) {

                final StepModel stepModel = transform(stepEntity);

                if (stepModel != null) {
                    stepModels.add(stepModel);
                }
            }
        }
        return stepModels;
    }

}
