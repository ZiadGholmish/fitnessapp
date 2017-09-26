package com.fitnessapp.data.repository;


import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.data.model.mapper.DiscountEntityMapper;
import com.fitnessapp.data.model.mapper.StepEntityMapper;
import com.fitnessapp.data.repository.datasource.FitnessDataFactory;
import com.fitnessapp.domain.repository.FitnessRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;

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
        fitnessDataFactory.create().saveStepCount(stepCount);
    }

    @Override
    public Flowable<List<StepEntity>> getTotalStepCount() {
        return fitnessDataFactory.create().getTotalStepCount();
    }

    @Override
    public void resetTotalCount() {
        fitnessDataFactory.create().resetTotalCount();
    }


    @Override
    public Flowable<List<DiscountEntity>> getAvailableDiscount(int stepCount) {
        return fitnessDataFactory.create().getAvailableDiscounts(stepCount);
    }

    @Override
    public Flowable<List<DiscountEntity>> getAllDiscounts() {
        return fitnessDataFactory.create().getAllDiscounts();
    }

    @Override
    public void saveDiscount(DiscountEntity discountEntity) {
        fitnessDataFactory.create().saveDiscount(discountEntity);
    }
}
