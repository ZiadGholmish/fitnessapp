package com.fitnessapp.dagger;


import com.fitnessapp.presentation.views.discounts.DiscountsActivity;
import com.fitnessapp.presentation.views.home.HomeActivity;
import com.fitnessapp.presentation.views.offerdetails.OfferDetailsActivity;
import com.fitnessapp.presentation.views.offerdetails.OfferDetailsContract;
import com.fitnessapp.presentation.views.user.UserDetailsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ziadgholmish on 6/15/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(HomeActivity homeActivity);

    void inject(DiscountsActivity discountsActivity);

    void inject(UserDetailsActivity userDetailsActivity);

    void inject(OfferDetailsActivity offerDetailsActivity);
}
