package com.example.petwellapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignInView extends AppCompatActivity {

    EditText etEmail, etPassword;
    ImageButton ibArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_view);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        Button btnSignIn = findViewById(R.id.btn_signin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = etEmail.getText().toString();
                String passwordText = etPassword.getText().toString();
                Toast.makeText(SignInView.this, emailText+" "+passwordText, Toast.LENGTH_SHORT).show();
            }
        });

        ibArrow = (ImageButton) findViewById(R.id.ib_arrow);
        ibArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });

    }
}