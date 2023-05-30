package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView forget;
    EditText tx_nick, tx_pass;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        login = (Button) findViewById(R.id.bt_login);
        forget = (TextView) findViewById(R.id.tx_forget);
        tx_nick = (EditText) findViewById(R.id.tx_nick);
        tx_pass = (EditText) findViewById(R.id.tx_pass);

        sharedPreferences = getSharedPreferences("user_detail", MODE_PRIVATE);
        sharedPreferences.contains("nickname");
        sharedPreferences.contains("password");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nick = tx_nick.getText().toString();
                String pass = tx_pass.getText().toString();

//                if (nick.equals("ren") && pass.equals("12")) {
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("nickname",nick);
//                    editor.putString("password",pass);
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
}