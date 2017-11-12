package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
import com.fitnessapp.domain.repository.FitnessRepository;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by carriagecompany on 9/28/17.
 */

public class ResetTotalStepCountUseCase extends UseCase<Void, Void> {

    private FitnessRepository fitnessRepository;

    @Inject
    public ResetTotalStepCountUseCase(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }

    @Override
    public Observable<Void> buildUseCaseObservable(Void aVoid) {
        fitnessRepository.resetTotalCount();
        return Observable.empty();
    }


}
