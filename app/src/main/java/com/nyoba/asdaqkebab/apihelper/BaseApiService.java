package com.nyoba.asdaqkebab.apihelper;

import com.nyoba.asdaqkebab.model.ResponseMenu;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("http://192.168.4.213:8000/api/login/")
    public Call<ResponseBody> loginRequest(@Field("username") String nick,
                                           @Field("password") String password);

    @GET("/api/allmenu")
    Call<ResponseMenu> getMenu();
}
