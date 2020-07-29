package com.example.cryptocurrencygetallcoins;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTest {
    public static Retrofit getInstance()
    {
        return  new Retrofit.Builder().baseUrl("https://min-api.cryptocompare.com/data/").addConverterFactory(GsonConverterFactory.create()).build();
    }
}
// dozvoljava da se koristi ta metoda iako ne postoji objekat te klase