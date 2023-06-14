package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nyoba.asdaqkebab.apihelper.BaseApiService;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView forget;
    EditText nick, pass;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        login = (Button) findViewById(R.id.bt_login);
        forget = (TextView) findViewById(R.id.tx_forget);
        nick = (EditText) findViewById(R.id.tx_nick);
        pass = (EditText) findViewById(R.id.tx_pass);

        sharedPreferences = getSharedPreferences("user_detail", MODE_PRIVATE);
        sharedPreferences.contains("nickname");
        sharedPreferences.contains("password");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...",true, false);
//                requestLogin();
//                if (nick.equals("ren") && pass.equals("saya")) {
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("nickname", String.valueOf(nick));
//                    editor.putString("password", String.valueOf(pass));
//                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
//                } else {
//                    Toast.makeText(LoginActivity.this, "Data gak valid", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });
    }
    private void requestLogin() {
        mApiService.loginRequest(nick.getText().toString(), pass.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody>response) {
                        if (response.isSuccessful()) {
                            loading.dismiss();
                            try {
                                JSONObject jsonResult = new JSONObject(response.body().string());
                                if (jsonResult.getString("error").equals("false")){
                                    Toast.makeText(mContext, "Berhasil Login", Toast.LENGTH_SHORT).show();
                                    String nick = jsonResult.getJSONObject("nick").getString("nama");
                                    Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                                    intent.putExtra("result_nama", nick);
                                    startActivity(intent);
                                } else {
                                    String error_message = jsonResult.getString("error_msg");
                                    Toast.makeText(mContext, "error_message", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR >" + t.toString());
                    }
                });
    }
}