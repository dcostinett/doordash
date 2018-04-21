package com.doordash.doordashlite.presentation.list;

import com.doordash.doordashlite.mvp.UiThreadQueue;
import com.doordash.doordashlite.presentation.common.BasePresenter;

public class RestaurantListPresenter extends BasePresenter<RestaurantListContract.ListView> implements RestaurantListContract.Presenter {
    private final RestaurantListViewModelFactory factory;

    public RestaurantListPresenter(UiThreadQueue queue, RestaurantListViewModelFactory factory) {
        super(queue);
        this.factory = factory;
    }

    @Override
    public void attach(RestaurantListContract.ListView view) {
        super.attach(view);
        RestaurantListViewModel viewModel = factory.create();
        uiThreadQueue.run(() -> view.show(viewModel));
    }
}
