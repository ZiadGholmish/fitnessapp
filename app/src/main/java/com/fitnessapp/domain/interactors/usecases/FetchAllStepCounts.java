package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
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

public class FetchAllStepCounts extends UseCase<List<StepEntity>, Void> {

    private FitnessRepository fitnessRepository;

    @Inject
    public FetchAllStepCounts(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }

    @Override
    public Observable<List<StepEntity>> buildUseCaseObservable(Void aVoid) {
        return fitnessRepository.getTotalStepCount().toObservable();
    }
}
