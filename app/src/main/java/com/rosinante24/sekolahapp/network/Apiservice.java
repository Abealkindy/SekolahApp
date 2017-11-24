package com.rosinante24.sekolahapp.network;

import com.rosinante24.sekolahapp.response.SekolahResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Rosinante24 on 24/11/17.
 */

public interface Apiservice {
    @Headers({"Authorization: " + "wfc2X6K0P9OVUTJkRE3DIYdrqMRSPCeCtFn8JnhpXbapVgL0bnyupIct23Ii6hw5"})
    @GET("sekolah")
    Call<SekolahResponse> getSekolah();
}
