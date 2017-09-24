package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
import com.fitnessapp.domain.repository.FitnessRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

/**
 * Created by carriagecompany on 9/24/17.
 */

public class SaveStepCountUseCase extends UseCase<Void, SaveStepCountUseCase.Params> {

    private FitnessRepository fitnessRepository;

    @Inject
    public SaveStepCountUseCase(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }

    @Override
    public Observable<Void> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params.stepCount);
        fitnessRepository.saveStepCount(params.stepCount);
        return Observable.empty();
    }

    public static final class Params {
        private int stepCount;

        private Params(int stepCount) {
            this.stepCount = stepCount;
        }

        public static Params forSaveStep(int stepCount) {
            return new SaveStepCountUseCase.Params(stepCount);
        }
    }


}
