package com.doordash.doordashlite.presentation.common;

public interface Presenter<V extends View> {
    void attach(V var);

    void detach();
}
