package com.fitnessapp.domain.repository;


import com.fitnessapp.data.model.DiscountEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by carriagecompany on 8/7/17.
 */

public interface FitnessRepository {

    void saveStepCount(int stepCount);

    int getTotalStepCount();

    void resetTotalCount();

    DiscountEntity getAvailableDiscount(int stepCount);


}
