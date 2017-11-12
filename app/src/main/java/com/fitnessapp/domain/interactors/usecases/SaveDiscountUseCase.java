package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.domain.repository.FitnessRepository;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by carriagecompany on 9/26/17.
 */

public class SaveDiscountUseCase extends UseCase<Void, SaveDiscountUseCase.Params> {

    private FitnessRepository fitnessRepository;

    @Inject
    public SaveDiscountUseCase(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }


    @Override
    public Observable<Void> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params.discountModel);
        fitnessRepository.saveDiscount(params.discountModel);
        return Observable.empty();
    }

    public static final class Params {

        private DiscountModel discountModel;

        private Params(DiscountModel discountModel) {
            this.discountModel = discountModel;
        }

        public static SaveDiscountUseCase.Params forSaveDiscount(DiscountModel discountModel) {
            return new SaveDiscountUseCase.Params(discountModel);
        }
    }


}

