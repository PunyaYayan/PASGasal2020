package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmConfiguration;

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
    String team;
    String alternate;
    String league;
    String stadium;
    String badge;
    String description;
    String location;
    String id;

    TextView tvname;
    TextView tvalternate;
    TextView tvleague;
    TextView tvstadium;
    TextView tvlocation;
    TextView tvdesc;
    ImageView ivposter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favourite);
        setTitle("Detail Team");
        extras = getIntent().getExtras();
        tvname = (TextView)findViewById(R.id.tvclub);
        tvalternate = (TextView)findViewById(R.id.tvclub2);
        tvleague = (TextView)findViewById(R.id.tvliga);
        tvstadium = (TextView)findViewById(R.id.tvstadium);
        tvlocation = (TextView)findViewById(R.id.tvlokasi);
        tvdesc = (TextView)findViewById(R.id.tvdeskripsi);
        ivposter = (ImageView) findViewById(R.id.ivposter);

        if (extras != null) {
            id = extras.getString("id");
            team = extras.getString("team");
            alternate = extras.getString("alternate");
            league = extras.getString("league");
            stadium = extras.getString("stadium");
            location = extras.getString("location");
            description = extras.getString("description");
            badge = extras.getString("badge");

            tvname.setText(team);
            tvalternate.setText(alternate);
            tvleague.setText(league);
            tvstadium.setText(stadium);
            tvlocation.setText(location);
            tvdesc.setText(description);
            Glide.with(DetailFavourite.this)
                    .load(badge)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivposter);
            // and get whatever type user account id is
        }
    }
}
