package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
import com.fitnessapp.domain.model.AppSettingsModel;
import com.fitnessapp.domain.model.StepModel;
import com.fitnessapp.domain.repository.FitnessRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by carriagecompany on 11/12/17.
 */

public class FetchAppSettingsUseCase extends UseCase<AppSettingsModel, Void> {

    private FitnessRepository fitnessRepository;

    @Inject
    public FetchAppSettingsUseCase(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }

    @Override
    public Observable<AppSettingsModel> buildUseCaseObservable(Void aVoid) {
        return fitnessRepository.getAppSettings().toObservable();
    }
}