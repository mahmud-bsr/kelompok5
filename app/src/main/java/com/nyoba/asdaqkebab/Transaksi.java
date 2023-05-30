package com.nyoba.asdaqkebab;

public class Transaksi {
    private String name;
    private int jumlah;
    private int harga;

    public Transaksi(String name, int jumlah, int harga) {
//        this.photoId = photoId;
        this.name = name;
        this.jumlah = jumlah;
        this.harga = harga;
    }

//    public int getPhotoId() {
//        return photoId;
//    }
//
//    public void setPhotoId(int photoId) {
//        this.photoId = photoId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
