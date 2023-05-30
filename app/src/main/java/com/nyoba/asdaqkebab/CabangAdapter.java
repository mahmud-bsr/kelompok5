package com.nyoba.asdaqkebab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CabangAdapter extends ArrayAdapter {
    private String[] Nama;
    private int[] Jumlah, Harga, SubTotal;
    private Context context;

    CabangAdapter(@NonNull Context context, String[] nama, int[] jumlah, int[] harga, int[] subTotal) {
        super(context, R.layout.cabang_listview, nama);
        this.Nama = nama;
        this.Jumlah = jumlah;
        this.Harga = harga;
        this.SubTotal = subTotal;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.cabang_listview,null, true);
        TextView nama = view.findViewById(R.id.nama);
        TextView jumlah = view.findViewById(R.id.jumlah);
        TextView harga = view.findViewById(R.id.harga);
        TextView subTotal = view.findViewById(R.id.sub_total);

        nama.setText(Nama[position]);
        jumlah.setText(Jumlah[position]);
        harga.setText(Harga[position]);
        subTotal.setText(SubTotal[position]);
        return view;
    }
}
