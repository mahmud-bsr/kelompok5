package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nyoba.asdaqkebab.databinding.ActivityLaporanCabangBinding;

public class LaporanCabangActivity extends AppCompatActivity {

    private ActivityLaporanCabangBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaporanCabangBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_laporan_cabang);
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        
        

        Items laplist = null;

        if (getIntent().hasExtra(HomeActivity.NEXT_SCREEN)) {
            laplist = (Items) getIntent().getSerializableExtra(HomeActivity.NEXT_SCREEN);
        }
        if (laplist != null) {
            binding.displayTanggal.setText(laplist.getTanggal());
            binding.displayKota.setText(laplist.getKota());
            binding.displayPemasukkan.setText(laplist.getPemasukkan());
        }
    }
}