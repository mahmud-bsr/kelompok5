package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetActivity extends AppCompatActivity {

    EditText email;
    Button submitEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        email = (EditText) findViewById(R.id.et_email);
        submitEmail = (Button) findViewById(R.id.btn_submit_email);

        submitEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetActivity.this, OtpActivity.class);
                startActivity(intent);
            }
        });
    }
}