package com.example.petwellapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
//        Button btn = findViewById(R.id.btn_signin);

        Button btn = findViewById(R.id.btn_shopping);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeView.this, ShoppingView.class);
                startActivity(intent);
            }
        });

        ImageButton abtn = findViewById(R.id.ib_anatomy);
        abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeView.this, AnatomyDog.class);
                startActivity(intent);
            }
        });
        ImageButton bbtn = findViewById(R.id.ib_care);
        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeView.this, chatbot_view.class);
                startActivity(intent);
            }
        });

        ImageButton cbtn = findViewById(R.id.ib_shopping);
        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeView.this, ShoppingView.class);
                startActivity(intent);
            }
        });

    }

//



}

