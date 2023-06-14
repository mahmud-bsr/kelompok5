package com.nyoba.asdaqkebab.apihelper;

public class UtilsApi {
    public static final String BASE_URL_API = "http://192.168.4.213:8000/api/";

    public static BaseApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
