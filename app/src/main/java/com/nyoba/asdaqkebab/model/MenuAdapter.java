package com.nyoba.asdaqkebab.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nyoba.asdaqkebab.model.MenuModel;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<MenuModel> {
        public MenuAdapter(Context context, int resource, List<MenuModel> menuList) {
            super(context, resource, menuList);
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Implementasi tampilan item di Spinner jika diperlukan
        // Anda dapat menggunakan layout khusus untuk menampilkan item
        // atau mengatur tampilan secara manual di sini

        // Contoh penggunaan layout bawaan Android Studio
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        // Mengambil data dari item di posisi tertentu
        MenuModel menuModel = getItem(position);

        // Mengisi tampilan item dengan data yang sesuai
        if (menuModel != null) {
            TextView textView = convertView.findViewById(android.R.id.text1);
            textView.setText(menuModel.getNama_menu());
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // Implementasi tampilan item di daftar dropdown Spinner jika diperlukan
        // Anda dapat menggunakan layout khusus untuk menampilkan item dropdown
        // atau mengatur tampilan secara manual di sini

        // Contoh penggunaan layout bawaan Android Studio
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        // Mengambil data dari item di posisi tertentu
        MenuModel menuModel = getItem(position);

        // Mengisi tampilan item dengan data yang sesuai
        if (menuModel != null) {
            TextView textView = convertView.findViewById(android.R.id.text1);
            textView.setText(menuModel.getNama_menu());
        }

        return convertView;
    }
}
