package com.fitnessapp.app;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.fitnessapp.dagger.AppComponent;
import com.fitnessapp.dagger.AppModule;
import com.fitnessapp.dagger.DaggerAppComponent;
import com.fitnessapp.dagger.NetworkModule;
import com.fitnessapp.data.database.FitnessLocalDataBase;


/**
 * Created by carriagecompany on 8/2/17.
 */

public class App extends MultiDexApplication {

    private static Context context;

    private AppComponent applicationComponent;

    private static FitnessLocalDataBase fitnessLocalDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        context = getApplicationContext();
        initializeInjector();
        initLocalDataBase();
    }

    public static Context getContext() {
        return context;
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    public static  FitnessLocalDataBase getFitnessLocalDataBase() {
        if (fitnessLocalDataBase == null) {
            initLocalDataBase();
        }
        return fitnessLocalDataBase;
    }

    private static void initLocalDataBase() {
        fitnessLocalDataBase = Room.databaseBuilder(context, FitnessLocalDataBase.class, AppConstants.DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

}
