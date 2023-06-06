package com.example.sabaesewa.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sabaesewa.CardItem;
import com.example.sabaesewa.R;
import com.example.sabaesewa.ServiceProviderList;


import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private Context context;
    private List<CardItem> cardItemList;

    public CardAdapter(Context context, List<CardItem> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CardItem cardItem = cardItemList.get(position);

        holder.cardImage.setImageResource(cardItem.getImageRes());
        holder.cardTitle.setText(cardItem.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the corresponding activity based on the card item clicked
                switch (position) {
                    case 0:
                    case 2:
                    case 1:
                        // Open Plumber activity
                        // Open Carpenter activity
                        // Open AC Mechanic activity
                        Intent acMechanicIntent = new Intent(context, ServiceProviderList.class);
                        context.startActivity(acMechanicIntent);
                        break;

//                    case 0:
//                        // Open AC Mechanic activity
//                        Intent acMechanicIntent = new Intent(context, ServiceProviderList.class);
//                        context.startActivity(acMechanicIntent);
//                        break;
//                    case 1:
//                        // Open Plumber activity
//                        Intent plumberIntent = new Intent(context, ServiceProviderList.class);
//                        context.startActivity(plumberIntent);
//                        break;
//                    case 2:
//                        // Open Carpenter activity
//                        Intent carpenterIntent = new Intent(context, ServiceProviderList.class);
//                        context.startActivity(carpenterIntent);
//                        break;
                    // Add cases for other card items as needed
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardTitle = itemView.findViewById(R.id.cardTitle);
        }
    }
}