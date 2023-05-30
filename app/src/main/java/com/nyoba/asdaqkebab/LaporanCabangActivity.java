package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nyoba.asdaqkebab.databinding.ActivityLaporanCabangBinding;

public class LaporanCabangActivity extends AppCompatActivity {

    private ActivityLaporanCabangBinding binding;
    ListView lv;

    String[] Nama = {"Kebab", "Burger Sapi", "Burger Ayam", "Hotdog",
            "Kebab Special", "Burger Jumbo", "Kebab Sosis", "Kebab Telur", "Kebab Jumbo"
    };
    int[] Jumlah = new int[]{
            10, 15 ,5 ,8, 9, 12, 20, 6, 10
    };
    int[] Harga = new int[]{
            15000,  25000, 20000, 30000, 18000, 15000, 20000, 21000, 30000
    };
    int[] SubTotal = new int[]{
            15000, 160000 , 250000, 250000, 30000, 120000, 205000, 640000, 102000
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaporanCabangBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_laporan_cabang);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("CabangIN");
        toolbar.setSubtitle("username");
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_new_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lv = (ListView) findViewById(R.id.list_cabang);
        CabangAdapter cabangAdapter = new CabangAdapter(this, Nama, Jumlah, Harga, SubTotal);
        lv.setAdapter(cabangAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "You Have selected :" + Nama[position], Toast.LENGTH_SHORT).show();
            }
        });
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
//
//
//
//        Items laplist = null;
//
//        if (getIntent().hasExtra(HomeActivity.NEXT_SCREEN)) {
//            laplist = (Items) getIntent().getSerializableExtra(HomeActivity.NEXT_SCREEN);
//        }
//        if (laplist != null) {
//            binding.displayTanggal.setText(laplist.getTanggal());
//            binding.displayKota.setText(laplist.getKota());
//            binding.displayPemasukkan.setText(laplist.getPemasukkan());
//        }
    }
}