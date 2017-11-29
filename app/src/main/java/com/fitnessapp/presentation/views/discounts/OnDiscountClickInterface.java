package com.fitnessapp.presentation.views.discounts;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.model.DiscountModel;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by ziadgholmish on 8/8/17.
 */

public interface OnDiscountClickInterface {

    void onDiscountItemSelected(DiscountModel discountEntity);
}
