package com.example.petwellapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.petwellapp.Entity.User;
import com.example.petwellapp.client.RetrofitClient;
import com.example.petwellapp.databinding.ActivityMain2Binding;
import com.example.petwellapp.response.BaseWebResponse;
import com.example.petwellapp.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    private Button btnSubmit;
    public EditText etName = null;
    public EditText etEmail = null;
    public EditText etPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main2);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnSubmit = findViewById(R.id.submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Kena klik", Toast.LENGTH_SHORT).show();
                registerUser();
            }
        });

        ImageButton btn2 = findViewById(R.id.ib_back);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void registerUser(){
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        ApiService apiService = RetrofitClient.getApiService();
        Call<BaseWebResponse<User>> call = apiService.registerUser(name, email, password);

        call.enqueue(new Callback<BaseWebResponse<User>>() {
            @Override
            public void onResponse(Call<BaseWebResponse<User>> call, Response<BaseWebResponse<User>> response) {
                BaseWebResponse<User> baseResponse = response.body();
                if (baseResponse != null && baseResponse.getStatus().equals("1")){
                    User user = baseResponse.getData();
                    Toast.makeText(MainActivity2.this, user.getEmail(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity2.this, baseResponse.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseWebResponse<User>> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Network Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}