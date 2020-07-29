package com.example.cryptocurrencygetallcoins;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Coin implements Comparable<Coin>{

    @SerializedName("ImageUrl")
    String img ="";

    @SerializedName("CoinName")
    String coinName ="";

    @SerializedName("Symbol")
    String symbol ="";

    @SerializedName("Id")
    String id = "";

    @SerializedName("Url")
    String url = "";

    @SerializedName("ContentCreatedOn")
    String contentCreatedOn = "";

    @SerializedName("Name")
    String name = "";

    @SerializedName("FullName")
    String fullName = "";

    @SerializedName("Algorithm")
    String algorithm = "";

    @SerializedName("ProofType")
    String proofType = "";

    @SerializedName("FullyPremined")
    String fullyPremined = "";

    @SerializedName("TotalCoinSupply")
    String totalCoinSupply = "";

    @SerializedName("BuiltOn")
    String builtOn = "";

    @SerializedName("SmartContractAddress")
    String smartContractAddress = "";

    @SerializedName("PreMinedValue")
    String preMinedValue = "";

    @SerializedName("TotalCoinsFreeFloat")
    String totalCoinsFreeFloat = "";

    @SerializedName("SortOrder")
    String sortOrder = "";



    @Override
    public int compareTo(Coin o) {

        if(sortOrder == o.sortOrder)
        return 0;
        else if(Double.valueOf(sortOrder)>Double.valueOf(o.sortOrder))
            return 1;
        else
            return -1;
    }
}
