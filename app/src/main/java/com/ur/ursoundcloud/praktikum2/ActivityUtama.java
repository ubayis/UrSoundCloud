package com.ur.ursoundcloud.praktikum2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ur.ursoundcloud.R;

public class ActivityUtama extends AppCompatActivity {

    Button buttonadd;
    Button buttonlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
        casting();

    }

    private void casting(){
        buttonadd = (Button)findViewById(R.id.buttonadd);
        buttonlist = (Button)findViewById(R.id.butttonlist);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaActivityRegister = new Intent(ActivityUtama.this,ActivityRegistrasi.class);
                startActivity(bukaActivityRegister);
            }
        });
    }
}
