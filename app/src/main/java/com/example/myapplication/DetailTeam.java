package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailTeam extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    ModelMovieRealm movieModel;


    Bundle extras;
    String club;
    String alternate;
    String deskripsi;
    String path;
    String liga;
    String stadium;
    String locate;
    String id;

    TextView tvclub;
    TextView tvalternate;
    ImageView ivposter;
    TextView tvdesc;
    TextView tvleague;
    TextView tvstadium;
    TextView tvlocate;
    Button btnbookmark;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);


        getSupportActionBar().hide();

        extras = getIntent().getExtras();
        tvclub = (TextView)findViewById(R.id.tvclub);
        tvalternate = (TextView)findViewById(R.id.tvclub2);
        ivposter = (ImageView) findViewById(R.id.ivposter);
        tvdesc = (TextView)findViewById(R.id.tvdeskripsi);
        tvleague = (TextView)findViewById(R.id.tvliga);
        tvstadium = (TextView)findViewById(R.id.tvstadium);
        tvlocate = (TextView)findViewById(R.id.tvlokasi);
        btnbookmark = (Button) findViewById(R.id.btnbookmark);

        if (extras != null) {
            id = extras.getString("id");
            club = extras.getString("team");
            alternate = extras.getString("alternate");
            liga = extras.getString("league");
            stadium = extras.getString("stadium");;
            path = extras.getString("badge");
            deskripsi = extras.getString("description");
            locate = extras.getString("location");

            tvclub.setText(club);
            tvalternate.setText(alternate);
            tvdesc.setText(deskripsi);
            tvleague.setText(liga);
            tvstadium.setText(stadium);
            tvlocate.setText(locate);

            Glide.with(DetailTeam.this)
                    .load(path)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivposter);
            // and get whatever type user account id is
        }

        //Set up Realm
        Realm.init(DetailTeam.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(configuration);

        btnbookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieModel = new ModelMovieRealm();
                movieModel.setTeam_name(club);
                movieModel.setAlternate_name(alternate);
                movieModel.setBadge_path(path);
                movieModel.setStadium(stadium);
                movieModel.setLeague(liga);
                movieModel.setBadge_path(path);
                movieModel.setStadium_location(locate);
                movieModel.setDescription(deskripsi);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(movieModel);


            }
        });
    }
}