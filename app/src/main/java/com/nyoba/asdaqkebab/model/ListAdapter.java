package com.nyoba.asdaqkebab.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nyoba.asdaqkebab.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> namabarangList;
    private ArrayList<String> jumlahList;
    private ArrayList<String> hargaList;
    private ArrayList<String> hargaTotalList;
    private int totalHarga = 0;

    public ListAdapter(Context context, ArrayList<String> namabarangList,
                         ArrayList<String> jumlahList,
                       ArrayList<String> hargaList, ArrayList<String> hargaTotalList) {
        super(context, R.layout.list_item, namabarangList);
        this.context = context;
        this.namabarangList = namabarangList;
        this.jumlahList = jumlahList;
        this.hargaList = hargaList;
        this.hargaTotalList = hargaTotalList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textViewNamabarang = rowView.findViewById(R.id.textViewNamabarang);
        TextView textViewHarga = rowView.findViewById(R.id.textViewHarga);

        // Set nilai teks untuk setiap TextView
        textViewNamabarang.setText(namabarangList.get(position));
        textViewHarga.setText(hargaList.get(position));

//        totalHarga = 0; // Reset total harga sebelum menghitung
//        for (String harga : hargaList) {
//            totalHarga += Integer.parseInt(harga);
//        }

//        TextView textViewTotalHarga = rowView.findViewById(R.id.textViewHargaTotal);
//        textViewTotalHarga.setText("Total: " + totalHarga);

        return rowView;
    }
}
