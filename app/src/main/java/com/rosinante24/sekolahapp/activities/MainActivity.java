package com.rosinante24.sekolahapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.rosinante24.sekolahapp.R;
import com.rosinante24.sekolahapp.adapter.SekolahRecyclerAdapter;
import com.rosinante24.sekolahapp.network.Apiservice;
import com.rosinante24.sekolahapp.network.RetrofitConfig;
import com.rosinante24.sekolahapp.response.SekolahResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Apiservice apiservice = RetrofitConfig.getInstance();
        Call<SekolahResponse> responseCall = apiservice.getSekolah();
        responseCall.enqueue(new Callback<SekolahResponse>() {
            @Override
            public void onResponse(Call<SekolahResponse> call, Response<SekolahResponse> response) {
                recycler.setAdapter(new SekolahRecyclerAdapter(getApplicationContext(), response.body().getData()));
            }

            @Override
            public void onFailure(Call<SekolahResponse> call, Throwable t) {

            }
        });
    }
}
