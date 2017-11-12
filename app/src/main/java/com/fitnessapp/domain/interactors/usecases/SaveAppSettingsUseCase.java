package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
import com.fitnessapp.domain.model.AppSettingsModel;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.domain.repository.FitnessRepository;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by carriagecompany on 11/12/17.
 */

public class SaveAppSettingsUseCase extends UseCase<Void, SaveAppSettingsUseCase.Params> {

    private FitnessRepository fitnessRepository;

    @Inject
    public SaveAppSettingsUseCase(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }

    @Override
    public Observable<Void> buildUseCaseObservable(SaveAppSettingsUseCase.Params params) {
        Preconditions.checkNotNull(params.appSettingsModel);
        fitnessRepository.saveAppSetting(params.appSettingsModel);
        return Observable.empty();
    }

    public static final class Params {

        private AppSettingsModel appSettingsModel;

        private Params(AppSettingsModel appSettingsModel) {
            this.appSettingsModel = appSettingsModel;
        }

        public static SaveAppSettingsUseCase.Params forSaveDiscount(AppSettingsModel appSettingsModel) {
            return new SaveAppSettingsUseCase.Params(appSettingsModel);
        }
    }


}

