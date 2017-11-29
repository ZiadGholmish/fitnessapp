package com.fitnessapp.presentation.views.offerdetails;

import android.content.Intent;
import android.util.Log;

import com.fitnessapp.app.AbsPresenter;
import com.fitnessapp.app.AppConstants;
import com.fitnessapp.domain.interactors.usecases.GetAllDiscountsUseCase;
import com.fitnessapp.domain.interactors.usecases.SaveDiscountUseCase;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.presentation.views.discounts.DiscountsContract;

import javax.inject.Inject;

/**
 * Created by carriagecompany on 11/29/17.
 */

public class OfferDetailsPresenter extends AbsPresenter<OfferDetailsContract.View> implements OfferDetailsContract.Actions {


    @Inject
    public OfferDetailsPresenter() {
    }

    @Override
    public void getOfferDetails(Intent intent) {

        if (intent == null) {
            Log.e("offer details screen", "intent is null");
            return;
        }
        DiscountModel discountModel = intent.getParcelableExtra(AppConstants.INTENT_DISCOUNT_ITEM);
        if (discountModel != null) {
            mView.showOfferDetails(discountModel);
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
