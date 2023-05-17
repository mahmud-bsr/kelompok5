package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtpActivity extends AppCompatActivity {

    Button submitOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        submitOtp = (Button) findViewById(R.id.btn_submit_otp);

        submitOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtpActivity.this, ConfirmForgetActivity.class);
                startActivity(intent);
            }
        });
    }
}