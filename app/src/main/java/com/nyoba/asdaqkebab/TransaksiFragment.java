package com.nyoba.asdaqkebab;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.nyoba.asdaqkebab.apihelper.BaseApiService;
import com.nyoba.asdaqkebab.apihelper.RetrofitClient;
import com.nyoba.asdaqkebab.apihelper.UtilsApi;
import com.nyoba.asdaqkebab.model.MenuModel;
import com.nyoba.asdaqkebab.model.ResponseMenu;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class TransaksiFragment extends Fragment {
    Spinner spinner_nama;
    Spinner spinner_jumlah;
    private ArrayAdapter<MenuModel> adapter;
    String nama, jumlah;
    private Button tmblTambah;
    ArrayList<String>daftar_nama;
    ArrayList<String>daftar_jumlah;
    Context mContext;
    BaseApiService mApiService;
    ProgressDialog loading;
    TableLayout tabelTransaksi;

    public TransaksiFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        Button tmblTambah = new Button(getActivity());
        tmblTambah = (Button) view.findViewById(R.id.btn_tambah);
        spinner_nama = (Spinner) view.findViewById(R.id.sp_nama_barang);
        spinner_jumlah = (Spinner) view.findViewById(R.id.sp_jumlah_barang);
        tabelTransaksi = (TableLayout) view.findViewById(R.id.tabel);

        mApiService = UtilsApi.getAPIService();

        BaseApiService baseApiService = RetrofitClient.getClient("http://192.168.4.213:8000/api/").create(BaseApiService.class);
        Call<ResponseMenu> call = baseApiService.getMenu();
        call.enqueue(new Callback<ResponseMenu>() {
            @Override
            public void onResponse(Call<ResponseMenu> call, Response<ResponseMenu> response) {
                if (response.isSuccessful()) {
                    ResponseMenu transaksi = response.body();
                    List<MenuModel> menuList = transaksi.getMenu();
                    adapter = new MenuAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, menuList);
                    spinner_nama.setAdapter(adapter);
                } else {
                    handleError(response);
                }
            }

            @Override
            public void onFailure(Call<ResponseMenu> call, Throwable t) {

            }
        });


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.1.3:8000/api/allmenu/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();


//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//
//            }
//        });
//        String jsonData = "[{'nama': 'Kebab biasa', 'jumlah': 10, 'harga': 150000}," +
//                "{'nama': 'Burger', 'jumlah': 10, 'harga': 250000}," +
//                "{'nama': 'Hotdog', 'jumlah': 15, 'harga': 450000}," +
//                "{'nama': 'Burger Jumbo', 'jumlah': 20, 'harga': 450000}," +
//                "{'nama': 'Kebab Jumbo', 'jumlah': 6, 'harga': 80000}," +
//                "{'nama': 'Kebab Telur', 'jumlah': 5, 'harga': 100000}," +
//                "{'nama': 'Kebab Sosis', 'jumlah': 5, 'harga': 80000}]";
//        setData(jsonData);


//        daftar_nama = new ArrayList<String>();
//
//        daftar_nama.add("Pak Hermawan");
//        daftar_nama.add("Pak Tanto");
//        daftar_nama.add("Bu Sulis");
//        daftar_nama.add("Pak Putri");
//        daftar_nama.add("Bu Marwan");
//        daftar_nama.add("Pak Ugik");

        daftar_jumlah = new ArrayList<String>();

        daftar_jumlah.add("1");
        daftar_jumlah.add("2");
        daftar_jumlah.add("3");
        daftar_jumlah.add("4");
        daftar_jumlah.add("5");
        daftar_jumlah.add("6");
        daftar_jumlah.add("7");
        daftar_jumlah.add("8");
        daftar_jumlah.add("9");
        daftar_jumlah.add("10");
        daftar_jumlah.add("11");
        daftar_jumlah.add("12");
        daftar_jumlah.add("13");
        daftar_jumlah.add("14");
        daftar_jumlah.add("15");
        daftar_jumlah.add("16");
        daftar_jumlah.add("17");
        daftar_jumlah.add("18");
        daftar_jumlah.add("19");
        daftar_jumlah.add("20");
        daftar_jumlah.add("21");
        daftar_jumlah.add("22");
        daftar_jumlah.add("23");
        daftar_jumlah.add("24");

        ArrayAdapter<String> adapter_nama = new ArrayAdapter<>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,daftar_nama);
        ArrayAdapter<String> adapter_jumlah = new ArrayAdapter<>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,daftar_jumlah);

//        spinner_nama.setAdapter(adapter_nama);
        spinner_jumlah.setAdapter(adapter_jumlah);

        spinner_nama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nama = spinner_nama.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_jumlah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jumlah = spinner_jumlah.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        tmblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nama.equals("") && !jumlah.equals("")) {
                    MenuModel menuModel = (MenuModel) spinner_nama.getSelectedItem();
                    String namaMenu = menuModel.getNama_menu();

                    // Buat baris baru untuk tabel
                    TableRow newRow = new TableRow(getActivity());

                    // Buat TextView untuk kolom nama
                    TextView txtNama = new TextView(getActivity());
                    txtNama.setText(namaMenu);
                    newRow.addView(txtNama);

                    // Buat TextView untuk kolom jumlah
                    TextView txtJumlah = new TextView(getActivity());
                    txtJumlah.setText(jumlah);
                    newRow.addView(txtJumlah);

                    // Buat TextView untuk kolom harga (contoh)
//                    TextView txtHarga = new TextView(getContext());
//                    txtHarga.setText(harga);
//                    newRow.addView(txtHarga);

                    // Tambahkan baris baru ke tabel layout
                    tabelTransaksi.addView(newRow);

                    Toast.makeText(getActivity(), "Anda Memilih " + namaMenu + jumlah, Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
    private void handleError(Response<ResponseMenu> response) {
        String errorMessage = "";

        if (response.errorBody() != null) {
            try {
                errorMessage = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            errorMessage = response.message();
        }

        Log.e("API Error", errorMessage);
        // Handle the error message accordingly (e.g., show an error dialog, toast, etc.)
    }
    private void initSpinnerMenu(){
        loading = ProgressDialog.show(getActivity(), null, "harap tunggu...", true, false);

        mApiService.getMenu().enqueue(new Callback<ResponseMenu>() {
            @Override
            public void onResponse(Call<ResponseMenu> call, Response<ResponseMenu> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    List<MenuModel> MenuItems = response.body().getMenu();
                    if (MenuItems != null && !MenuItems.isEmpty()) {
                        List<String> listSpinner = new ArrayList<>();
                        for (int i = 0; i < MenuItems.size(); i++) {
                            listSpinner.add(MenuItems.get(i).getNama_menu());
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                                android.R.layout.simple_spinner_item, listSpinner);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_nama.setAdapter(adapter);
                    } else {
                        // Tangani jika MenuItems null atau kosong
                    }
                } else {
                    loading.dismiss();
                }
            }

            public void onFailure(Call<ResponseMenu> call, Throwable t) {
                loading.dismiss();
                // Menangani kesalahan jaringan atau kesalahan pada request
                Toast.makeText(getActivity(), "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
//    public class MenuItem {
//        private String name;
//
//        public MenuItem(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
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

