package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtusername;
    EditText txtpassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtusername = findViewById(R.id.EditTxt1);
        txtpassword = findViewById(R.id.EditTxt2);
        btnlogin    = findViewById(R.id.Btn1);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtusername.getText().toString().isEmpty() || txtpassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Mohon Diisi Semuanya", Toast.LENGTH_SHORT).show();
                } else {
                    if (txtusername.getText().toString().equals("zayyancahyar") && txtpassword.getText().toString().equals("123456")){
                        Toast.makeText(MainActivity.this, "Selamat", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Coba Lagi", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}