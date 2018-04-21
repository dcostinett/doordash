package com.doordash.doordashlite.net;

import com.doordash.doordashlite.domain.Restaurant;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestaurantApi {

    @GET("/v2/restaurant/?lat={lat}&lng={lng}&offset=0&limit=50")
    Observable<Response<List<Restaurant>>> getRestaurants(@Path("lat") String lat, @Path("lng") String lng);

    @GET("/v2/restaurant/{restaurantId}/")
    Observable<Response<Restaurant>> getRestaurant(@Path("restaurantId") String restaurantId);
}
