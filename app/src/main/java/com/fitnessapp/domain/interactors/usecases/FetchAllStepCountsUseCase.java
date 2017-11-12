package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
import com.fitnessapp.domain.model.StepModel;
import com.fitnessapp.domain.repository.FitnessRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableElementAt;

/**
 * Created by carriagecompany on 9/24/17.
 */

public class FetchAllStepCountsUseCase extends UseCase<List<StepModel>, Void> {

    private FitnessRepository fitnessRepository;

    @Inject
    public FetchAllStepCountsUseCase(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }

    @Override
    public Observable<List<StepModel>> buildUseCaseObservable(Void aVoid) {
        return fitnessRepository.getTotalStepCount().toObservable();
    }
}
