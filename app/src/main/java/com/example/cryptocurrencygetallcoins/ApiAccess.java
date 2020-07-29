package com.example.cryptocurrencygetallcoins;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiAccess {

    @GET("all/coinlist")
    Call<BaseResponse> getCryptoData();

    @GET("price")
    Call<CoinPrice> getPrice(@Query("fsym") String fsym,@Query("tsyms") String tsyms);
}
