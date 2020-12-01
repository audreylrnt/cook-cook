package com.example.cookcook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView tvError;
    EditText etFullName,etUsername,etPassword;
    Button btnRegister,btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvError = findViewById(R.id.tvErrorMsg);
        tvError.setVisibility(View.INVISIBLE);
        etFullName = findViewById(R.id.etfullname);
        etFullName.getBackground().setAlpha(50);
        etUsername = findViewById(R.id.etUsername);
        etUsername.getBackground().setAlpha(50);
        etPassword = findViewById(R.id.etPassword);
        etPassword.getBackground().setAlpha(50);
        btnRegister = findViewById(R.id.btnRegister);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}