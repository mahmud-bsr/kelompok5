package com.nyoba.asdaqkebab.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransaksiModel {

    @SerializedName("nama_menu")
    @Expose
    private String namaMenu;

    @SerializedName("qty")
    @Expose
    private Integer jumlah;

    @SerializedName("sub_total")
    @Expose
    private String subTotal;



    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }
}
