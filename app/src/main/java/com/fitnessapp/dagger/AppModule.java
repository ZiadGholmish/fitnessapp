package com.fitnessapp.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;


import com.fitnessapp.app.AppConstants;
import com.fitnessapp.data.database.FitnessLocalDataBase;
import com.fitnessapp.data.executor.JobExecutor;
import com.fitnessapp.data.repository.FitnessDataRepository;
import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.repository.FitnessRepository;
import com.fitnessapp.presentation.UIThread;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPref(Context context) {
        return context.getSharedPreferences(AppConstants.SHARED_NAME_FITNESS, 0);
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    FitnessRepository provideUserRepository(FitnessDataRepository articleRepository) {
        return articleRepository;
    }


}
