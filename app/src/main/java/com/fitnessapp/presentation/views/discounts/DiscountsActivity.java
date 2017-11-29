package com.fitnessapp.presentation.views.discounts;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.fitnessapp.R;
import com.fitnessapp.app.App;
import com.fitnessapp.app.AppConstants;
import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.presentation.views.home.HomeContract;
import com.fitnessapp.presentation.views.home.HomePresenter;
import com.fitnessapp.presentation.views.offerdetails.OfferDetailsActivity;
import com.fitnessapp.presentation.views.offerdetails.OfferDetailsContract;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiscountsActivity extends AppCompatActivity implements DiscountsContract.View {

    @Inject
    DiscountsPresenter discountsPresenter;

    @BindView(R.id.discounts_recycler)
    RecyclerView discounts_recycler;

    @BindView(R.id.btn_back)
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discounts);
        ButterKnife.bind(this);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        discountsPresenter.attachView(this);
        discountsPresenter.getDiscounts();

    }

    @Override
    public void showDiscounts(List<DiscountModel> discountEntities) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        discounts_recycler.setLayoutManager(linearLayoutManager);
        DiscountsAdapter discountsAdapter = new DiscountsAdapter(getApplicationContext(), discountEntities, onDiscountClickInterface);
        discounts_recycler.setAdapter(discountsAdapter);
    }


    @OnClick(R.id.btn_back)
    void goBack() {
        finish();
    }

    private OnDiscountClickInterface onDiscountClickInterface = discountEntity -> {
        Intent intent = new Intent(DiscountsActivity.this, OfferDetailsActivity.class);
        intent.putExtra(AppConstants.INTENT_DISCOUNT_ITEM, discountEntity);
        startActivity(intent);
    };

}
