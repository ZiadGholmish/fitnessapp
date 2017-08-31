package com.fitnessapp.data.repository;


import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.mapper.DiscountEntityMapper;
import com.fitnessapp.data.model.mapper.StepEntityMapper;
import com.fitnessapp.data.repository.datasource.FitnessDataFactory;
import com.fitnessapp.domain.repository.FitnessRepository;

import javax.inject.Inject;

/**
 * Created by carriagecompany on 8/6/17.
 */

public class FitnessDataRepository implements FitnessRepository {

    FitnessDataFactory fitnessDataFactory;

    StepEntityMapper stepEntityMapper;

    DiscountEntityMapper discountEntityMapper;

    @Inject
    FitnessDataRepository(FitnessDataFactory fitnessDataFactory,
                          StepEntityMapper stepEntityMapper,
                          DiscountEntityMapper discountEntityMapper) {

        this.fitnessDataFactory = fitnessDataFactory;
        this.stepEntityMapper = stepEntityMapper;
        this.discountEntityMapper = discountEntityMapper;
    }

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
