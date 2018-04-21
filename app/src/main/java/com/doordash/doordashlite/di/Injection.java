package com.doordash.doordashlite.di;

import android.content.Context;
import android.os.Environment;

public class Injection {
    private AppComponent appComponent;
    private static Injection instance;

    private Injection(Context context) {
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(context))
                .build();
    }

    public static Injection create(Context context) {
        if (instance == null) {
            instance = new Injection(context);
        }
        return instance;
    }

    public static Injection instance() {
        return instance;
    }

    public void destroy() {
        instance = null;
    }

    public AppComponent getComponent() {
        return appComponent;
    }

    public void setComponent(AppComponent component) {
        if (component != null) {
            appComponent = component;
        }
    }
}
