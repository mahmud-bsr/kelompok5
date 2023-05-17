package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfirmForgetActivity extends AppCompatActivity {

    EditText pass;
    EditText confirmPass;
    Button loginUlang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_forget);

        pass = (EditText) findViewById(R.id.et_ganti_pass);
        confirmPass = (EditText) findViewById(R.id.et_confirm_pass);
        loginUlang = (Button) findViewById(R.id.btn_log_abisganti);

        loginUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmForgetActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}