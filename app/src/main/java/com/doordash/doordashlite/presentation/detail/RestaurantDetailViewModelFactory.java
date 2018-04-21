package com.doordash.doordashlite.presentation.detail;

import android.content.Context;

public class RestaurantDetailViewModelFactory {
    private Context context;

    public RestaurantDetailViewModelFactory(Context context) {
        this.context = context;
    }

    public RestaurantDetailViewModel create() {
        RestaurantDetailViewModel model = new RestaurantDetailViewModel();

        return model;
    }
}
