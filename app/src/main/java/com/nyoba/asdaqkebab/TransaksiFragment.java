package com.nyoba.asdaqkebab;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nyoba.asdaqkebab.apihelper.BaseApiService;
import com.nyoba.asdaqkebab.apihelper.RetrofitClient;
import com.nyoba.asdaqkebab.apihelper.UtilsApi;
import com.nyoba.asdaqkebab.model.ListAdapter;
import com.nyoba.asdaqkebab.model.MenuAdapter;
import com.nyoba.asdaqkebab.model.MenuModel;
import com.nyoba.asdaqkebab.model.ResponseMenu;
import com.nyoba.asdaqkebab.model.TransaksiItem;
import com.nyoba.asdaqkebab.model.TransaksiModel;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class TransaksiFragment extends Fragment {
    Spinner spinner_nama;
    EditText et_jumlah;
    TextView tvTotal;
    Button tmblHapus, tmblTambah;
    private ArrayAdapter<MenuModel> adapter;
    String namaBarang;
    int harga;
    int jumlah;
    BaseApiService mApiService;
    ProgressDialog loading;
    Call<TransaksiModel> dataTr;
    private List<TransaksiItem> transaksiItems;
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private ArrayList<String> namabarangList;
    private ArrayList<String> jumlahList;
    private ArrayList<String> hargaList;
    private ArrayList<String> hargaTotalList;
    private int totalHarga = 0;

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
        et_jumlah = (EditText) view.findViewById(R.id.et_jumlah_barang);
        tmblHapus = (Button) view.findViewById(R.id.btn_hapus);
        tvTotal = (TextView) view.findViewById(R.id.textViewTotal);
        TextView textViewTotalHarga = view.findViewById(R.id.textViewHargaTotal);


        listView = view.findViewById(R.id.listTransaksi);
        namabarangList = new ArrayList<>();
        jumlahList = new ArrayList<>();
        hargaList = new ArrayList<>();
        hargaTotalList = new ArrayList<>();



        ListAdapter listAdapter = new ListAdapter(getActivity(), namabarangList, jumlahList, hargaList, hargaTotalList);
        listView.setAdapter(listAdapter);

        transaksiItems = new ArrayList<>();

        mApiService = UtilsApi.getAPIService();

        BaseApiService baseApiService = RetrofitClient.getClient("http://192.168.1.7:8000/api/").create(BaseApiService.class);
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

        spinner_nama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                namaBarang = spinner_nama.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        tmblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!nama.equals("") && !jumlah.equals("")) {
                    MenuModel menuModel = (MenuModel) spinner_nama.getSelectedItem();
                    String namaMenu = menuModel.getNama_menu();
                    int hargaMenu = menuModel.getHarga();
                String inputData = et_jumlah.getText().toString();


                if (!inputData.isEmpty()) {
                    String newDataMenu = namaMenu + ": " + inputData + "     ,Harga : " + hargaMenu;
                    int dataharga = hargaMenu * Integer.parseInt(inputData);
                    totalHarga += dataharga;
                    namabarangList.add(newDataMenu);
                    hargaList.add("Total : " + String.valueOf(dataharga));
                    listAdapter.notifyDataSetChanged();
                    et_jumlah.setText("");
//                    tvTotal =

//                    textViewTotalHarga.setText("Total Harga: " + totalHarga);
                } else {
                    Toast.makeText(getActivity(), "Masukkan data terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
//                    String namaBarang = spinner_nama.get().toString();
//                    int jumlah = Integer.parseInt(et_jumlah.getSelectedItem().toString());
//
//                    TransaksiItem transaksiItem = new TransaksiItem(namaBarang, jumlah, harga);
//                    transaksiItems.add(transaksiItem);


//                    addItemToList();
//                    Toast.makeText(getActivity(), "Anda Menambah " + jumlahText + " " + namaMenu , Toast.LENGTH_LONG).show();
//                }
            }
        });

        tmblHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    private void addItemToList() {
        String selectedItem = spinner_nama.getSelectedItem().toString();
        String enteredText = et_jumlah.getText().toString();

        if (!TextUtils.isEmpty(selectedItem) && !TextUtils.isEmpty(enteredText)) {
            String item = selectedItem + "   " + enteredText;
            namabarangList.add(item);
            listAdapter.notifyDataSetChanged();

            // Reset input fields
            spinner_nama.setSelection(0);
            et_jumlah.setText("");
        } else {
            Toast.makeText(requireContext(), "Isi semua field", Toast.LENGTH_SHORT).show();
        }
    }




    private TransaksiItem createTransaksiItem(String selectedValue) {
        // Membuat objek TransaksiItem dari item yang dipilih
        // Misalnya, Anda bisa menggunakan logika untuk mengambil harga, jumlah, dll. berdasarkan item yang dipilih dari spinner
        // Mengembalikan objek TransaksiItem yang baru dibuat
        return new TransaksiItem(selectedValue, 1, (int) 10.0);
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
}

