package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailMovie extends AppCompatActivity {

    Bundle extras;
    String team;
    String alternate;
    String stadium;
    String descrription;
    String badge;
    String id;

    Realm realm;
    RealmHelper realmHelper;
    ModelMovieRealm teamModel;

    TextView tvname;
    TextView tvalternate;
    TextView tvstadium;
    ImageView ivposter;
    TextView tvdesc;
    Button btnbookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        getSupportActionBar().hide();
        extras = getIntent().getExtras();
        tvname = (TextView)findViewById(R.id.tvname);
        tvalternate =(TextView) findViewById(R.id.tvalternative);
        tvstadium =(TextView) findViewById(R.id.tvstadium);
        tvdesc = (TextView)findViewById(R.id.tvdesc);
        ivposter = (ImageView) findViewById(R.id.ivposter);
        btnbookmark = (Button) findViewById(R.id.btnbookmark);

        if (extras != null) {
            id = extras.getString("id");
            team = extras.getString("team");
            alternate = extras.getString("alternate");
            descrription = extras.getString("description");
            badge = extras.getString("badge");

            tvname.setText(team);
            tvalternate.setText(alternate);
            tvstadium.setText(stadium);
            tvdesc.setText(descrription);
            Glide.with(DetailMovie.this)
                    .load(badge)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivposter);
            // and get whatever type user account id is
        }
        //Set up Realm
        Realm.init(DetailMovie.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnbookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamModel = new ModelMovieRealm();
                teamModel.setStadiumname(team);
                teamModel.setAlternativename(alternate);
                teamModel.setStadiumname(stadium);
                teamModel.setDesc(descrription);
                teamModel.setPath(badge);
                realmHelper = new RealmHelper(realm);
                realmHelper.save(teamModel);
            }
        });
    }
}