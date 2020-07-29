package com.example.cryptocurrencygetallcoins;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseResponse {
    @SerializedName("Data")
    HashMap<String, Coin> data;

    public ArrayList<Coin> getValues(){
        return new ArrayList<>(data.values());
    }
}
