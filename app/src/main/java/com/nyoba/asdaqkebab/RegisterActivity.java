package com.nyoba.asdaqkebab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    private EditText tgl, nama, alamat, pass;
    private RadioGroup gender;
    private Button submit;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat;

    private final Calendar calendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponents();
//        onClickValidate();

        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tgl = (EditText) findViewById(R.id.txt_date);
        tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdateDialog();
            }
        });
        submit = (Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showdateDialog(){

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR ,  i );
                calendar.set(Calendar.MONTH , i1);
                calendar.set(Calendar.DAY_OF_MONTH , i2);

                calendar.set(i, i1, i2);

                tgl.setText(dateFormat.format(calendar.getTime()));
            }
        };
        this.tgl.setOnClickListener(view -> {
            new DatePickerDialog(RegisterActivity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

//        this.submit.setOnClickListener(view -> {
//            RadioButton rdbtn = findViewById(gender.getCheckedRadioButtonId());
//            String data = nama.getText().toString()+"\n"
//                    + alamat.getText().toString()+"\n"+ pass.getText().toString()+"\n"+ tgl.getText().toString()+"\n"+ rdbtn.getText().toString()+"\n";);
    }

    public void initComponents(){
//        this.tgl = findViewById(R.id.txt_date);
        this.nama = findViewById(R.id.txt_name);
        this.alamat = findViewById(R.id.txt_alamat);
        this.pass = findViewById(R.id.txt_pass);
        this.submit = findViewById(R.id.btn_submit);
        this.gender = findViewById(R.id.grp_gen);

    }



}