package com.nyoba.asdaqkebab;

import java.io.Serializable;

public class Items implements Serializable {

    private final String tanggal;
    private final String kota;
    private final int pemasukkan;

    public Items(String tanggal, String kota, int pemasukkan) {
        this.tanggal = tanggal;
        this.kota = kota;
        this.pemasukkan = pemasukkan;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getKota() {
        return kota;
    }
    public int getPemasukkan() {
        return pemasukkan;
    }
//    private String tanggal;
//    private String kota;
//    private int pemasukan;

//    public Items(String tanggal, String kota, int pemasukan) {
//        this.tanggal = tanggal;
//        this.kota = kota;
//        this.pemasukan = pemasukan;
//    }
//    public String getTanggal() {
//        return tanggal;
//    }
//    public void setTanggal() {
//        this.tanggal = tanggal;
//    }
//    public String getKota() {
//        return kota;
//    }
//    public void setKota() {
//        this.kota = kota;
//    }
//    public int getPemasukan() {
//        return pemasukan;
//    }
//    public void setPemasukan(int pemasukan) {
//        this.pemasukan = pemasukan;
//    }
}
