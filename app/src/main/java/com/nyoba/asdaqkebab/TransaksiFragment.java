package com.nyoba.asdaqkebab;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class TransaksiFragment extends Fragment {

//    private Button tmblTambah;
//    private RecyclerView recyclerView;
//    private TransaksiAdapter adapter;
//    private ArrayList<Transaksi> TrArrayList;

    public TransaksiFragment() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        Button tmblTambah = new Button(getActivity());
//        tmblTambah = (Button) view.findViewById(R.id.btn_tambah);

//        String jsonData = "[{'nama': 'Kebab biasa', 'jumlah': 10, 'harga': 150000}," +
//                "{'nama': 'Burger', 'jumlah': 10, 'harga': 250000}," +
//                "{'nama': 'Hotdog', 'jumlah': 15, 'harga': 450000}," +
//                "{'nama': 'Burger Jumbo', 'jumlah': 20, 'harga': 450000}," +
//                "{'nama': 'Kebab Jumbo', 'jumlah': 6, 'harga': 80000}," +
//                "{'nama': 'Kebab Telur', 'jumlah': 5, 'harga': 100000}," +
//                "{'nama': 'Kebab Sosis', 'jumlah': 5, 'harga': 80000}]";
//        setData(jsonData);

//        RecyclerView list = view.findViewById(R.id.recycler_view);
//        adapter = new TransaksiAdapter(this,createTransaksi());
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        list.setLayoutManager(layoutManager);
//        list.setAdapter(list.getAdapter());
//        tmblTambah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Barang ditambahkan", Toast.LENGTH_SHORT).show();
//            }
//        });
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_transaksi, container, false);
//        return view;
//        recyclerView = view.findViewById(R.id.recycler_view);
//        adapter = new TransaksiAdapter(TrArrayList);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        return view;
    }

//    void setData(String jsonString){
//        try {
//            JSONArray jsonArray = new JSONArray(jsonString);
//            TrArrayList = new ArrayList<>();
//            for (int i=0; i<jsonArray.length(); i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                Transaksi items = new Transaksi(jsonObject.getString("nama"),
//                        jsonObject.getInt("jumlah"),
//                        jsonObject.getInt("pemasukkan"));
//                TrArrayList.add(items);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//    private List<Transaksi> createTransaksi() {
//        List<Transaksi>data = new ArrayList<>();
//        data.add(new Transaksi("Kebab Jumbo",10,250000));
//        data.add(new Transaksi("Kebab Asdaq",5,125000));
//        data.add(new Transaksi("Burger Jumbo",10,300000));
//        data.add(new Transaksi("Kebab",20,230000));
//        data.add(new Transaksi("Hotdog",15,350000));
//        data.add(new Transaksi("Burger Mini",10,250000));
//        data.add(new Transaksi("Kebab Medium",9,180000));
//
//        return data;
//    }

}