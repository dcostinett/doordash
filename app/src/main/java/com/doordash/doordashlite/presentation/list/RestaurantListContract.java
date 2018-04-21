package com.doordash.doordashlite.presentation.list;

import com.doordash.doordashlite.presentation.common.View;

public class RestaurantListContract {
    interface ListView extends View {
        void show(RestaurantListViewModel viewModel);
    }

    interface Presenter {
        void attach(RestaurantListContract.ListView view);
    }
}
