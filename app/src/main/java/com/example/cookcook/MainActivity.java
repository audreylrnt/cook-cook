package com.example.cookcook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvError;
    EditText etUsername, etPassword;
    Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvError = findViewById(R.id.tvErrorMsg);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        tvError.setVisibility(View.INVISIBLE);
        etUsername.getBackground().setAlpha(50);
        etPassword.getBackground().setAlpha(50);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText() + "";
                if(username.equals("")){
                    tvError.setText(getString(R.string.errorMessage));
                    tvError.setVisibility(View.VISIBLE);
                    return;
                }
                // sample code
                tvError.setText("Welcome, " + username);
                tvError.setVisibility(View.VISIBLE);
            }
        });
    }
}
