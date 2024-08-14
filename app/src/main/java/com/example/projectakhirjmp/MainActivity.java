package com.example.projectakhirjmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button btnlistdata, btninputdata, btninformasi,btnkeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlistdata = (Button) findViewById(R.id.buttonList);
        btninputdata = (Button) findViewById(R.id.buttonInput);
        btninformasi = (Button) findViewById(R.id.buttonInformasi);
        btnkeluar = (Button) findViewById(R.id.buttonKeluar);

        btnkeluar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }

        });

        btninputdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, LihatData.class);
                startActivity(intent);
            }
        });

        btninformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, InformasiAplikasi.class);
                startActivity(intent);
            }
        });

        btnlistdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListData.class);
                startActivity(intent);
            }
        });

    }
    }
