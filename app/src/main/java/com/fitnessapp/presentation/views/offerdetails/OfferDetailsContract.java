package com.fitnessapp.presentation.views.offerdetails;

import android.content.Intent;

import com.fitnessapp.domain.model.DiscountModel;

import java.util.List;

/**
 * Created by carriagecompany on 11/29/17.
 */

public interface OfferDetailsContract {

    interface View {
        void showOfferDetails(DiscountModel discountModel);
    }

    interface Actions {
        void getOfferDetails(Intent intent);
    }
}
