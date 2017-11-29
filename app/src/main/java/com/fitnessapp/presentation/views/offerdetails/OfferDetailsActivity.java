package com.fitnessapp.presentation.views.offerdetails;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.fitnessapp.R;
import com.fitnessapp.app.App;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.utils.ResourcesUtil;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class OfferDetailsActivity extends AppCompatActivity implements OfferDetailsContract.View {

    @Inject
    OfferDetailsPresenter offerDetailsPresenter;
    @BindView(R.id.offer_image)

    ImageView offerImage;
    @BindView(R.id.toolbar)

    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)

    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;

    @BindView(R.id.offer_details)
    TextView offerDetails;

    @BindView(R.id.offer_price)
    TextView offer_price;

    @BindView(R.id.store_image)
    CircleImageView storeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        offerDetailsPresenter.attachView(this);
        offerDetailsPresenter.getOfferDetails(getIntent());

    }

    @Override
    public void showOfferDetails(DiscountModel discountModel) {
        Picasso.with(getApplicationContext()).load(discountModel.getCardImage()).into(offerImage);
        Picasso.with(getApplicationContext()).load(discountModel.getStoreLogo()).into(storeImage);
        setTitle(discountModel.getStoreName());
        offerDetails.setText(discountModel.getDesc());
        offer_price.setText(String.format(ResourcesUtil.getString(R.string.price_label), discountModel.getPrice() + ""));
    }
}
