package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Xin chào"+username, Toast.LENGTH_SHORT).show();

        CardView cardExit = findViewById(R.id.cardExit);

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });

        CardView cardFindDoctor = findViewById(R.id.cardChat);
        cardFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, FindDoctor.class));
            }
        });

        CardView cardLabTest = findViewById(R.id.cardLabTest);
        cardLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, LabTest.class));
            }
        });

        CardView orderDetail = findViewById(R.id.cardOrder);
        orderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, OrderDetail.class));
            }
        });

        CardView buyMedic = findViewById(R.id.cardMedic);
        buyMedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, BuyMedic.class));
            }
        });

        CardView health = findViewById(R.id.cardBlog);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Blog.class));
            }
        });
    }
}