package com.ur.ursoundcloud.praktikum1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ur.ursoundcloud.R;

public class HomeActivity extends AppCompatActivity {

    TextView tvMusicly;
    String namaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        casting();
        ambilNama();
        buatSelamatBerbelanja();
    }

    private void casting() {
        tvMusicly = (TextView) findViewById(R.id.homepage);
    }

    private void ambilNama() {
        namaUser = getIntent().getStringExtra("username");
    }

    private void buatSelamatBerbelanja() {
        tvMusicly.setText("Connect on SoundCloud " +namaUser);
    }
}