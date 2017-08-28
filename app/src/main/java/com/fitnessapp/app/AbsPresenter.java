package com.fitnessapp.app;

import android.support.annotation.CallSuper;


public abstract class AbsPresenter<V> {

    public V mView;

    @CallSuper
    public void attachView(V view) {
        mView = view;
    }

    @CallSuper
    public void deAttachView() {
        mView = null;
    }

    public boolean isAttached() {
        return mView != null;
    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    public abstract void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    public abstract void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    public abstract void destroy();


}
