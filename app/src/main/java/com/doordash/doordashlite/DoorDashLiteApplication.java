package com.doordash.doordashlite;

import android.app.Application;
import timber.log.Timber;

public class DoorDashLiteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}
