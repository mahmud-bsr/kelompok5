package com.nyoba.asdaqkebab.apihelper;

import com.nyoba.asdaqkebab.model.ResponseMenu;
import com.nyoba.asdaqkebab.model.TransaksiModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {
//    @FormUrlEncoded
//    @POST("/api/login/")
//    public Call<LoginResponse> submitLogin(
//            @Field("username") String username,
//            @Field("password") String password
//    );

    @GET("/api/allmenu/")
    Call<ResponseMenu> getMenu();

    @POST("/api/hasil")
    Call<ResponseBody> addMenu(
            @Field("nama_menu") String namaMenu,
            @Field("jumlah") String jumlah
    );

    @POST("/api/hasil")
    Call<TransaksiModel> tambahTransaksi(
            @Field("nama_menu") String namaMenu,
            @Field("qty") String jumlah,
            @Field("sub_total") String subTotal
    );
}
