package com.example.cryptocurrencygetallcoins;

import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    ArrayList<Coin> listOfCoins;

    public RecycleViewAdapter(ArrayList<Coin> listOfCoins) {
        this.listOfCoins = listOfCoins;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_item,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int  position) {

        TextView cryptoName = holder.itemView.findViewById(R.id.coin_name);
        TextView cryptoSymbol = holder.itemView.findViewById(R.id.coin_symbol);
        cryptoName.setText(listOfCoins.get(position).coinName);
        cryptoSymbol.setText(listOfCoins.get(position).symbol);

        final ImageView imageView= holder.itemView.findViewById(R.id.image);
        final String imageUrl ="https://cryptocompare.com" + listOfCoins.get(position).img;
        final String coinName = listOfCoins.get(position).coinName;

                Glide.with(holder.itemView.getContext())
                .load("https://cryptocompare.com" + listOfCoins.get(position).img)
                .apply(RequestOptions.circleCropTransform())
                .into((ImageView) holder.itemView.findViewById(R.id.image));

        holder.itemView.setOnClickListener(new View.OnClickListener() { //drzi ceo item (layout) i zato nema potrebe za promenljivom
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Details.class);
                intent.putExtra("image",imageUrl);
                intent.putExtra("coinName",coinName);
                intent.putExtra("symbol",listOfCoins.get(position).symbol);
                intent.putExtra("id",listOfCoins.get(position).id);
                intent.putExtra("createdOn",listOfCoins.get(position).contentCreatedOn);
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfCoins.size();
    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    public RecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);
    }
}
