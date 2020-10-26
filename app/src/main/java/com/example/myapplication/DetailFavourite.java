package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailFavourite extends AppCompatActivity {

    Bundle extras;
    String title;
    String date;
    String deskripsi;
    String path;

    Realm realm;
    RealmHelper realmHelper;
    ModelMovieRealm movieModel;

    TextView tvjudul;
    ImageView ivposter;
    TextView tvdate, tvdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favourite);
        getSupportActionBar().hide();
        extras = getIntent().getExtras();
        tvjudul = (TextView) findViewById(R.id.tvjudulfav);
        tvdesc = (TextView) findViewById(R.id.tvdescfav);
        tvdate = (TextView) findViewById(R.id.tvdatefav);
        ivposter = (ImageView) findViewById(R.id.ivposterfav);

        if (extras != null) {
            title = extras.getString("judul");
            date = extras.getString("date");
            deskripsi = extras.getString("deskripsi");
            path = extras.getString("path");
            tvjudul.setText(title);
            tvdate.setText(date);
            tvdesc.setText(deskripsi);
            Glide.with(DetailFavourite.this)
                    .load(path)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivposter);
            // and get whatever type user account id is
        }
    }
}