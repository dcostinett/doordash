package com.doordash.doordashlite.presentation.detail;

import com.doordash.doordashlite.presentation.common.View;

public class RestaurantDetailContract {
    interface DetailView extends View {
        void show(RestaurantDetailViewModel viewModel);
    }

    interface Presenter {
        void attach(RestaurantDetailContract.DetailView view);
    }
}
