package com.doordash.doordashlite.di;

import com.doordash.doordashlite.presentation.list.RestaurantListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(RestaurantListActivity activity);
}
