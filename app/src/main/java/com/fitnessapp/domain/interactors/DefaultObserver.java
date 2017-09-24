package com.fitnessapp.domain.interactors;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by ziadgholmish on 8/8/17.
 */

/**
 * Default {@link DisposableObserver} base class to be used whenever you want default error handling.
 */
public class DefaultObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T t) {
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable exception) {
    }
}
