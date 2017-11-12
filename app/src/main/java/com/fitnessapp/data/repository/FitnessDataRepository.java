package com.fitnessapp.data.repository;


import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.data.model.mapper.DiscountEntityMapper;
import com.fitnessapp.data.model.mapper.StepEntityMapper;
import com.fitnessapp.data.repository.datasource.FitnessDataFactory;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.domain.model.StepModel;
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
    public Flowable<List<StepModel>> getTotalStepCount() {
        return fitnessDataFactory.create().getTotalStepCount().map(stepEntities ->
                stepEntityMapper.transform(stepEntities));
    }

    @Override
    public void resetTotalCount() {
        fitnessDataFactory.create().resetTotalCount();
    }


    @Override
    public Flowable<List<DiscountModel>> getAvailableDiscount(int stepCount) {
        return fitnessDataFactory.create().getAvailableDiscounts(stepCount).map(
                discountEntities -> discountEntityMapper.transform(discountEntities));
    }

    @Override
    public Flowable<List<DiscountModel>> getAllDiscounts() {
        return fitnessDataFactory.create().getAllDiscounts().map(
                discountEntities -> discountEntityMapper.transform(discountEntities));
    }

    @Override
    public void saveDiscount(DiscountModel discountModel) {
        fitnessDataFactory.create().saveDiscount(discountEntityMapper.transform(discountModel));
    }
}
