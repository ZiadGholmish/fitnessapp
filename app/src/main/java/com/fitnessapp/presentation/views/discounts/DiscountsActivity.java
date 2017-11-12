package com.fitnessapp.presentation.views.discounts;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fitnessapp.R;
import com.fitnessapp.app.App;
import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.presentation.views.home.HomeContract;
import com.fitnessapp.presentation.views.home.HomePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiscountsActivity extends AppCompatActivity implements DiscountsContract.View {

    @Inject
    DiscountsPresenter discountsPresenter;

    @BindView(R.id.discounts_recycler)
    RecyclerView discounts_recycler;

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
        DiscountsAdapter discountsAdapter = new DiscountsAdapter(getApplicationContext(), discountEntities, null);
        discounts_recycler.setAdapter(discountsAdapter);
    }


}
