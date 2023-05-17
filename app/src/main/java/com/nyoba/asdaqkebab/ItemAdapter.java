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
        itemViewHolder.tvTanggal.setText(datalist.get(i).getTanggal());
        itemViewHolder.tvKota.setText(String.valueOf(datalist.get(i).getKota()));
        itemViewHolder.tvPemasukan.setText(String.valueOf(datalist.get(i).getPemasukan()));
    }

    @Override
    public int getItemCount() {
        return (datalist !=null) ? datalist.size() : 0;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTanggal, tvKota, tvPemasukan;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = (TextView) itemView.findViewById(R.id.tv_tanggal);
            tvKota = (TextView) itemView.findViewById(R.id.tv_kota);
            tvPemasukan = (TextView) itemView.findViewById(R.id.tv_pemasukan);
        }
    }
}
