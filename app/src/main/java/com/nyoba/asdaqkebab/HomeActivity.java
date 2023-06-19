package com.nyoba.asdaqkebab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nyoba.asdaqkebab.databinding.FragmentLaporanBinding;

public class HomeActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavView;
    private boolean tabelku = false;
    private FragmentLaporanBinding binding;
    TextView tvResultNama;
    String resultNama;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLaporanBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_home);

        TextView tvResultNama = findViewById(R.id.txuser);
        sharedPreferences = getSharedPreferences("user_detail",MODE_PRIVATE);

//        Bundle extras = getIntent().getExtras();
//        if (extras != null)
//            resultNama = extras.getString("result_nama");
//            tvResultNama.setText(resultNama);
//        result.setText(sharedPreferences.getString("username",null));
//        setContentView(binding.getRoot());
//        final ArrayList<Items> laplist = Contstants.getItemsData();
//        binding.rvItem.setLayoutManager(new LinearLayoutManager(this));
//        binding.rvItem.setHasFixedSize(true);
//        final ItemAdapter ItemAdapter = new ItemAdapter(laplist);
//        binding.rvItem.setAdapter(ItemAdapter);
//        ItemAdapter.setOnClickListener(new ItemAdapter.OnClickListener() {
//            @Override
//            public void onClick(int position, Items model) {
//                Intent intent = new Intent(HomeActivity.this, LaporanCabangActivity.class);
//                intent.putExtra(NEXT_SCREEN, model);
//                startActivity(intent);
//            }
//        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.setSubtitle(" ");
        getSupportActionBar().setTitle("CabangIN");
        toolbar.setNavigationIcon(R.drawable.baseline_logout_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });

        bottomNavView = findViewById(R.id.bottomNavigationView);

        bottomNavView.setOnNavigationItemSelectedListener(this);
        bottomNavView.setSelectedItemId(R.id.transaksi);

    }
    public  static final String NEXT_SCREEN = "details_screen";

    TransaksiFragment transaksiFragment = new TransaksiFragment();
    LaporanFragment laporanFragment = new LaporanFragment();

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
        }
        return false;


    }

}