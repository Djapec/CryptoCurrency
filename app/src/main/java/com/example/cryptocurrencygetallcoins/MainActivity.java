package com.example.cryptocurrencygetallcoins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiAccess apiAccess = RetrofitTest.getInstance().create(ApiAccess.class); //singlic


        Call<BaseResponse> baseResponse = apiAccess.getCryptoData();


        baseResponse.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                ArrayList<Coin> coins = response.body().getValues();

                recyclerView = findViewById(R.id.crypto_coin_list);
                Collections.sort(coins);
                recyclerView.setAdapter(new RecycleViewAdapter(coins));
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

//                View view = findViewById(R.id.loading);
//                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {


            }
        });


    }
}
