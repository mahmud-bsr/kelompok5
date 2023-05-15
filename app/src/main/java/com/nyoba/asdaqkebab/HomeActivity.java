package com.nyoba.asdaqkebab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavView;
    private boolean tabelku = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavView = findViewById(R.id.bottomNavigationView);

        bottomNavView.setOnNavigationItemSelectedListener(this);
        bottomNavView.setSelectedItemId(R.id.transaksi);
    }

    TransaksiFragment transaksiFragment = new TransaksiFragment();
    LaporanFragment laporanFragment = new LaporanFragment();
    EditBarang editBarang = new EditBarang();
    EditMenuFragment editMenuFragment = new EditMenuFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.transaksi:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, transaksiFragment)
                        .commit();
                return true;

            case R.id.laporan:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, laporanFragment)
                        .commit();
                return true;

            case R.id.ed_barang:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, editBarang)
                        .commit();
                return true;
            case R.id.ed_menu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, editMenuFragment)
                        .commit();
                return true;
        }
        return false;


    }

    public void ciutkanTabel(View view) {
        TableLayout table = findViewById(R.id.tabel);
        Button pencet = findViewById(R.id.Button);

        table.setColumnCollapsed(1, tabelku);
        table.setColumnCollapsed(2, tabelku);

        if (tabelku) {
            tabelku = false;
            pencet.setText("Tunjukkan detail");
        } else {
            tabelku = true;
            pencet.setText("Detail tersembunyi");
        }
    }
}