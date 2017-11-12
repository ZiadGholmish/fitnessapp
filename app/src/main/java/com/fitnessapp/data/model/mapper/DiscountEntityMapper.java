package com.fitnessapp.data.model.mapper;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.model.DiscountModel;
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


    /**
     * Transform a {@link DiscountModel} into an {@link DiscountEntity}.
     *
     * @param discountModel Object to be transformed.
     * @return {@link DiscountEntity} if valid {@link DiscountModel} otherwise null.
     */
    public DiscountEntity transform(DiscountModel discountModel) {

        DiscountEntity discountEntity = null;

        if (discountModel != null) {

            discountEntity = new DiscountEntity();
            discountEntity.setStoreName(discountModel.getStoreName());
            discountEntity.setDesc(discountModel.getDesc());
            discountEntity.setStepCount(discountModel.getStepCount());
            discountEntity.setMealName(discountModel.getMealName());
            discountEntity.setImage(discountModel.getImage());
            discountEntity.setPercentage(discountModel.getPercentage());

        }
        return discountEntity;
    }


    /**
     * Transform a List of {@link DiscountEntity} into a Collection of {@link DiscountModel}.
     *
     * @param discountEntityCollection Object Collection to be transformed.
     * @return {@link DiscountModel} if valid {@link DiscountEntity} otherwise null.
     */
    public List<DiscountModel> transform(Collection<DiscountEntity> discountEntityCollection) {

        final List<DiscountModel> discountModels = new ArrayList<>();

        if (discountEntityCollection != null) {

            for (DiscountEntity discountEntity : discountEntityCollection) {

                final DiscountModel discountModel = transform(discountEntity);

                if (discountModel != null) {
                    discountModels.add(discountModel);
                }
            }
        }
        return discountModels;
    }

}
