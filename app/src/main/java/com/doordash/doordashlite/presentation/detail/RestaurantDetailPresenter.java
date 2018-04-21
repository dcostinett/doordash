package com.doordash.doordashlite.presentation.detail;

import com.doordash.doordashlite.mvp.UiThreadQueue;
import com.doordash.doordashlite.presentation.common.BasePresenter;

public class RestaurantDetailPresenter extends BasePresenter<RestaurantDetailContract.DetailView> implements RestaurantDetailContract.Presenter {
    private final RestaurantDetailViewModelFactory factory;

    public RestaurantDetailPresenter(UiThreadQueue queue, RestaurantDetailViewModelFactory factory) {
        super(queue);
        this.factory = factory;
    }

    @Override
    public void attach(RestaurantDetailContract.DetailView view) {
        super.attach(view);
        RestaurantDetailViewModel viewModel = factory.create();
        uiThreadQueue.run(() -> view.show(viewModel));
    }
}
