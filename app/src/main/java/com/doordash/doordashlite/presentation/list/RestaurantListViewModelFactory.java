package com.doordash.doordashlite.presentation.list;

import android.content.Context;

import javax.inject.Inject;

public class RestaurantListViewModelFactory {
    private Context context;

    @Inject
    public RestaurantListViewModelFactory(Context context) {
        this.context = context;
    }

    public RestaurantListViewModel create() {
        RestaurantListViewModel model = new RestaurantListViewModel();

        return model;
    }
}
