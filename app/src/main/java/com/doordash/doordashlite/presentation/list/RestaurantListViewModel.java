package com.doordash.doordashlite.presentation.list;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

public class RestaurantListViewModel extends BaseObservable {
    private String imageUrl;

    private String name;

    private List<String> tags;

    private String status;

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
