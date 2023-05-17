package com.nyoba.asdaqkebab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class LaporanFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private ArrayList<Items> itemsArrayList;

    public LaporanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_laporan, container, false);

        String jsonData = "[{'tanggal': '20/11/2023', 'kota': 'Jember', 'pemasukkan': 450000}," +
                "{'tanggal': '20/11/2024', 'kota': 'P.Bun', 'pemasukkan': 450000}," +
                "{'tanggal': '20/11/2025', 'kota': 'Prbo', 'pemasukkan': 450000}," +
                "{'tanggal': '20/11/2026', 'kota': 'Kaliurang', 'pemasukkan': 450000}," +
                "{'tanggal': '20/11/2027', 'kota': 'Kaliwates', 'pemasukkan': 450000}," +
                "{'tanggal': '20/11/2028', 'kota': 'Kotalama', 'pemasukkan': 450000}," +
                "{'tanggal': '20/11/2029', 'kota': 'Bondowoso', 'pemasukkan': 450000}]";
        setData(jsonData);

        recyclerView = view.findViewById(R.id.rv_item);
        adapter = new ItemAdapter(itemsArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    void setData(String jsonString){
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            itemsArrayList = new ArrayList<>();
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Items items = new Items(jsonObject.getString("tanggal"),
                        jsonObject.getString("kota"),
                        jsonObject.getInt("pemasukkan"));
                itemsArrayList.add(items);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}