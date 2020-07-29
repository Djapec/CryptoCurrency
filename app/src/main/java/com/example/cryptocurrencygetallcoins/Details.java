package com.example.cryptocurrencygetallcoins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Details extends FragmentActivity implements PageOne.OnFragmentInteractionListener , PageTwo.OnFragmentInteractionListener{

    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    public FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



//        mPager =  findViewById(R.id.pager);
//        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
//        mPager.setAdapter(pagerAdapter);



        ApiAccess apiAccessDetalies = RetrofitTest.getInstance().create(ApiAccess.class);

        final TextView  textViewDetails = findViewById(R.id.txt_details);
        ImageView imageViewDetails = findViewById(R.id.coin_logo);
        Intent intent = getIntent();
        final Bundle bd = intent.getExtras();

        Glide.with(this)
                .load(bd.get("image"))
                .apply(RequestOptions.circleCropTransform())
                .into(imageViewDetails);



        String fsym = (String) bd.get("symbol");

        Call<CoinPrice> coinPriceCall = apiAccessDetalies.getPrice(fsym,"USD,RSD,EUR");

        coinPriceCall.enqueue(new Callback<CoinPrice>() {
            @Override
            public void onResponse(Call<CoinPrice> call, Response<CoinPrice> response) {
                String coinPriceUSD = response.body().usd;
                String coinPriceDIN = response.body().rsd;
                String coinPriceEUR = response.body().eur;


                textViewDetails.setText(
                        "ID: "+bd.get("id")
                        + "\n"+ "Name: "+ bd.get("coinName")
                        + "\n"+ "Symbol: "+ bd.get("symbol")
                        + "\n"+"Prices:"
                        + "\n" + "USD: "+coinPriceUSD
                        + "\n" + "RSD: "+coinPriceDIN
                        + "\n" + "EUR: "+coinPriceEUR);
            }

            @Override
            public void onFailure(Call<CoinPrice> call, Throwable t) {

            }
        });


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

//    @Override
//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
//    }

    public void Sranje(){

        Bundle bundle = new Bundle();
        String str = "Message";
        bundle.putString("test", str);
        PageOne fragInfo = new PageOne();
        fragInfo.setArguments(bundle);
        fragmentTransaction.replace(R.id.pager,fragInfo);
        fragmentTransaction.commit();
    }
}
