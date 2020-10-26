package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtusername;
    EditText txtpassword;
    Button btnlogin, btnreg;
    LinearLayout constraintLayout;
    TextView tvTimeMsg;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("login", MODE_PRIVATE);

        constraintLayout = findViewById(R.id.container);
        tvTimeMsg = (TextView) findViewById(R.id.tv_time_msg);
        Calendar c = Calendar.getInstance();

        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 16) {
            //morning
            constraintLayout.setBackground(getDrawable(R.drawable.morning));
            tvTimeMsg.setText("Good Morning");
        } else if (timeOfDay >= 16 && timeOfDay < 24) {
            //night
            constraintLayout.setBackground(getDrawable(R.drawable.night));
            tvTimeMsg.setText("Good Night");
        }

        getSupportActionBar().hide();

        txtusername = findViewById(R.id.EditTxt1);
        txtpassword = findViewById(R.id.EditTxt2);
        btnlogin = findViewById(R.id.Btn1);
        btnreg = findViewById(R.id.BtnRegist);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtusername.getText().toString().isEmpty() || txtpassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mohon Diisi Semuanya", Toast.LENGTH_SHORT).show();
                } else {
                    if (txtusername.getText().toString().equals("zayyancahyar") && txtpassword.getText().toString().equals("123456")) {
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


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}