package com.fitnessapp.dagger;


import com.fitnessapp.presentation.views.home.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ziadgholmish on 6/15/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

   void inject(HomeActivity homeActivity);

}
