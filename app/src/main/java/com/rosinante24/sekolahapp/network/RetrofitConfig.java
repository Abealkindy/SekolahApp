package com.rosinante24.sekolahapp.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rosinante24 on 24/11/17.
 */

public class RetrofitConfig {
    private static Retrofit getInitRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://api.jakarta.go.id/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Apiservice getInstance() {
        return getInitRetrofit().create(Apiservice.class);
    }
}
