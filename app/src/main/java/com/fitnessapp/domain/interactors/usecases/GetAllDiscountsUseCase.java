package com.fitnessapp.domain.interactors.usecases;

import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.executor.PostExecutionThread;
import com.fitnessapp.domain.executor.ThreadExecutor;
import com.fitnessapp.domain.interactors.UseCase;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.domain.repository.FitnessRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by carriagecompany on 9/26/17.
 */

public class GetAllDiscountsUseCase extends UseCase<List<DiscountModel>, Void> {

    private FitnessRepository fitnessRepository;

    @Inject
    public GetAllDiscountsUseCase(FitnessRepository fitnessRepository, ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.fitnessRepository = fitnessRepository;
    }

    @Override
    public Observable<List<DiscountModel>> buildUseCaseObservable(Void aVoid) {
        return fitnessRepository.getAllDiscounts().toObservable();
    }
}

