package com.nyoba.asdaqkebab.model;

public class MenuModel {
    private String id_menu;
    private String nama_menu;
    private int harga;

    public MenuModel(String id_menu, String nama_menu, int harga) {
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
