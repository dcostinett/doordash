package com.doordash.doordashlite.di;

import android.content.Context;

import com.doordash.doordashlite.net.RestaurantApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    private static final String BASE_URL = "https://api.doordash.com";

    private Context context;

    public ApiModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }

    @Provides
    @Singleton
    public LoggingInterceptor provideLoggingInterceptor() {
        return new LoggingInterceptor.Builder()
                .loggable(true)
                .setLevel(Level.BODY)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .addHeader("version", "v2")
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        int timeout = 2;
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.MINUTES)
                .writeTimeout(timeout, TimeUnit.MINUTES)
                .connectTimeout(timeout, TimeUnit.MINUTES);

        return okHttpClientBuilder;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient.Builder builder, Gson gson, LoggingInterceptor loggingInterceptor) {
        return new Retrofit.Builder()
                .client(builder.addInterceptor(loggingInterceptor).build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    public RestaurantApi provideRestaurantApi(Retrofit retrofit) {
        return retrofit.create(RestaurantApi.class);
    }
}
