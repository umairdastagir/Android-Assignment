package com.cs6a.pet;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final CardView exit = findViewById(R.id.Exit);
        CardView add = findViewById(R.id.btnadd);
        CardView book = findViewById(R.id.btnbook);
        CardView info = findViewById(R.id.btninfo);
        CardView cmpd = findViewById(R.id.btnvehc);
        CardView users = findViewById(R.id.btnUsers);



        add.setVisibility(View.INVISIBLE);
        info.setVisibility(View.INVISIBLE);
        info.setVisibility(View.INVISIBLE);
        cmpd.setVisibility(View.INVISIBLE);

        cmpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, VehCompound.class);
                startActivity(i);
            }
        });

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Users.class);
                startActivity(i);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Book.class);
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, AddVeh.class);
                startActivity(i);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, VehInfo.class);
                startActivity(i);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
                finishAffinity();
            }
        });


    }
}
