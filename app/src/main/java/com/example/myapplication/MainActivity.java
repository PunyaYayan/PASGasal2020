package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtusername;
    EditText txtpassword;
    Button btnlogin;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref        = getSharedPreferences("login", MODE_PRIVATE);
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
                        //Saving Sp
                        editor = pref.edit();
                        editor.putString("username", txtusername.getText().toString());
                        editor.putString("status", "login");
                        editor.apply();
                        // Menuju Main Menu
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Coba Lagi", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}