package com.example.petwellapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.petwellapp.Entity.User;
import com.example.petwellapp.client.RetrofitClient;
import com.example.petwellapp.databinding.ActivitySignInViewBinding;
import com.example.petwellapp.response.BaseWebResponse;
import com.example.petwellapp.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_view);
        Button btnLogin = findViewById(R.id.btn_submit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        ImageButton btn2 = findViewById(R.id.btn_signinn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser(){
        EditText etEmail = findViewById(R.id.et_email2);
        EditText etPassword = findViewById(R.id.et_password3);
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        ApiService apiService = (ApiService) RetrofitClient.getApiService();
        Call<BaseWebResponse<User>> call = apiService.loginUser(email,password);

        call.enqueue(new Callback<BaseWebResponse<User>>() {
            @Override
            public void onResponse(Call<BaseWebResponse<User>> call, Response<BaseWebResponse<User>> response) {
                BaseWebResponse<User> baseResponse = response.body();
                if (baseResponse != null && baseResponse.getStatus().equals("1")){
                    User user = baseResponse.getData();
                    Toast.makeText(SignInView.this, user.getEmail(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInView.this, HomeView.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SignInView.this, baseResponse.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseWebResponse<User>> call, Throwable t) {
                Toast.makeText(SignInView.this, "Network Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}