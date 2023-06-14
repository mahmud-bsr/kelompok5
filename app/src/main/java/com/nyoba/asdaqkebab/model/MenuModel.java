package com.nyoba.asdaqkebab.model;

public class MenuModel {
    private String id_menu;
    private String nama_menu;
    private String harga;

    public MenuModel(String id_menu, String nama_menu, String harga) {
        this.id_menu = id_menu;
        this.nama_menu = nama_menu;
        this.harga = harga;
    }

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
