package com.nyoba.asdaqkebab.model;

public class TransaksiItem {
    private String namaBarang;
    private int jumlah;
    private int harga;

    public TransaksiItem(String namaBarang, int jumlah, int harga) {
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
