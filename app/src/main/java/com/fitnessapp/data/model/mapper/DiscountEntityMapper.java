package com.fitnessapp.data.model.mapper;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.model.DiscountModel;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by carriagecompany on 8/29/17.
 */

@Singleton
public class DiscountEntityMapper {

    @Inject
    public DiscountEntityMapper() {
    }

    /**
     * Transform a {@link DiscountEntity} into an {@link DiscountModel}.
     *
     * @param discountEntity Object to be transformed.
     * @return {@link DiscountModel} if valid {@link DiscountEntity} otherwise null.
     */
    public DiscountModel transform(DiscountEntity discountEntity) {

        DiscountModel discountModel = null;

        if (discountEntity != null) {

            discountModel = new DiscountModel();
            discountModel.setStoreName(discountEntity.getStoreName());
            discountModel.setDesc(discountEntity.getDesc());
            discountModel.setStepCount(discountEntity.getStepCount());
            discountModel.setMealName(discountEntity.getMealName());
            discountModel.setImage(discountEntity.getImage());
            discountModel.setPercentage(discountEntity.getPercentage());

        }
        return discountModel;
    }

}
