package com.doordash.doordashlite.presentation.common;

import com.doordash.doordashlite.mvp.UiThreadQueue;

public class BasePresenter<V extends View> implements Presenter<V> {
    protected V view;
    protected final UiThreadQueue uiThreadQueue;

    public BasePresenter(UiThreadQueue queue) {
        this.uiThreadQueue = queue;
    }

    @Override
    public void attach(V view) {
        this.view = view;
        uiThreadQueue.setEnabled(true);
    }

    @Override
    public void detach() {
        uiThreadQueue.setEnabled(false);
        view = null;
    }
}
