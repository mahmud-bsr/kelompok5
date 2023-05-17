package com.nyoba.asdaqkebab;

public class Items {
    private String tanggal;
    private String kota;
    private int pemasukan;

    public Items(String tanggal, String kota, int pemasukan) {
        this.tanggal = tanggal;
        this.kota = kota;
        this.pemasukan = pemasukan;
    }
    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal() {
        this.tanggal = tanggal;
    }
    public String getKota() {
        return kota;
    }
    public void setKota() {

        this.kota = kota;
    }

    public int getPemasukan() {

        return pemasukan;
    }

    public void setPemasukan(int pemasukan) {

        this.pemasukan = pemasukan;
    }
}
