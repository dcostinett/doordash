package com.doordash.doordashlite.di;

import android.content.Context;

import com.doordash.doordashlite.mvp.BackgroundThreadPool;
import com.doordash.doordashlite.mvp.CachedBackgroundThreadPool;
import com.doordash.doordashlite.mvp.UiThreadQueue;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public UiThreadQueue provideUiThreadQueue() {
        return new UiThreadQueue();
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public BackgroundThreadPool provideBackgroundThreadPool() {
        return new CachedBackgroundThreadPool();
    }
}
