package com.fitnessapp.presentation.views.discounts;

import com.fitnessapp.data.model.DiscountEntity;

import java.util.List;

/**
 * Created by carriagecompany on 9/25/17.
 */

public interface DiscountsContract {

    interface View {

        void showDiscounts(List<DiscountEntity> discountEntities);

    }

    interface Actions {

        void getDiscounts();
    }


}
