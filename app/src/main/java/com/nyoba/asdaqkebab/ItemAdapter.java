package com.nyoba.asdaqkebab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Items> datalist;

    public ItemAdapter(ArrayList<Items> datalist) {
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.card_items,viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.tvItem.setText(datalist.get(i).getName());
        itemViewHolder.tvQuantity.setText(String.valueOf(datalist.get(i).getQuantity()));
        itemViewHolder.tvPrice.setText(String.valueOf(datalist.get(i).getPrice()));
    }

    @Override
    public int getItemCount() {
        return (datalist !=null) ? datalist.size() : 0;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItem, tvQuantity, tvPrice;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_items);
            tvQuantity = (TextView) itemView.findViewById(R.id.tv_quantity);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
        }
    }
}
