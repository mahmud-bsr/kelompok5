package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nyoba.asdaqkebab.apihelper.BaseApiService;
import com.nyoba.asdaqkebab.apihelper.RetrofitClient;
import com.nyoba.asdaqkebab.apihelper.UtilsApi;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView forget;
    EditText nick, passw;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;
    SharedPreferences sharedpreferences;
    String  nama_user, username, password;
    Boolean session = false;
    public final static String TAG_NAMA_USER = "nama_user";
    public final static String TAG_USERNAME = "username";
    public final static String TAG_PASSWORD = "password";
    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        login = (Button) findViewById(R.id.bt_login);
        forget = (TextView) findViewById(R.id.tx_forget);
        nick = (EditText) findViewById(R.id.tx_nick);
        passw = (EditText) findViewById(R.id.tx_pass);

        mApiService = UtilsApi.getAPIService();

        BaseApiService apiService = RetrofitClient.getClient("http://192.168.1.7:8000/api/login/").create(BaseApiService.class);
        String username = "username";
        String password = "password";

// Membuat objek permintaan login
//        LoginRequest loginRequest = new LoginRequest(username, password);

// Memanggil metode layanan untuk melakukan permintaan login
//        Call<LoginResponse> call = apiService.login(loginRequest);
//        call.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (response.isSuccessful()) {
//                    // Tangani respons sukses
//                    LoginResponse loginResponse = response.body();
//                    // Lakukan sesuatu dengan respons loginResponse
//                } else {
//                    // Tangani respons gagal
//                    // ...
//                }
//            }

//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                // Tangani kegagalan permintaan
//                // ...
//            }
//        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loading = ProgressDialog.show(getApplicationContext(), null, "Harap Tunggu...",true, false);
//                requestLogin();
//                if (nick.equals("ren") && passw.equals("0000")) {
//                    SharedPreferences.Editor editor = sharedpreferences.edit();
//                    editor.putString("nickname", String.valueOf(nick));
//                    editor.putString("password", String.valueOf(passw));
//                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
//                } else {
//                    Toast.makeText(LoginActivity.this, "Data gak valid", Toast.LENGTH_SHORT).show();
//                }
            } //ini akhir
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });
    }


//    private void requestLogin(){
//        mApiService = RetrofitClient.getClient("http://192.168.1.7:8000/api/login/").create(BaseApiService.class);
//
//        mApiService.loginRequest(nick.getText().toString(), pass.getText().toString())
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        if (response.isSuccessful()){
//                            loading.dismiss();
//                            try {
//                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                if (jsonRESULTS.getString("error").equals("false")){
//                                    // Jika login berhasil maka data nama yang ada di response API
//                                    // akan diparsing ke activity selanjutnya.
//                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
////                                    String nama = jsonRESULTS.getJSONObject("user").getString("nama");
//                                    Intent intent = new Intent(mContext, HomeActivity.class);
////                                    intent.putExtra("result_nama", nama);
//                                    startActivity(intent);
//                                } else {
//                                    // Jika login gagal
//                                    String error_message = jsonRESULTS.getString("error_msg");
//                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            loading.dismiss();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();
//                    }
//                });
//    }

}