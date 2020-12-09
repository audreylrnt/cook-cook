package com.example.cookcook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
        //styling & show/hide error message
        tvError.setVisibility(View.INVISIBLE);
        etUsername.getBackground().setAlpha(50);
        etPassword.getBackground().setAlpha(50);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validation to match input with saved data
                String username = etUsername.getText() + "";
                String password = etPassword.getText() + "";
                if(UserDB.users.size() == 0) {
                    errorMessage(getString(R.string.errorMessageNoData));
                    return;
                }
                if(username.equals("") || password.equals("")){
                    errorMessage(getString(R.string.errorMessageEmpty));
                    return;
                }
                if(!username.equals(UserDB.users.get(0).getUserName())) {
                    errorMessage(getString(R.string.errorMessageWrongUsername));
                    return;
                }
                if(!password.equals(UserDB.users.get(0).getPassword())) {
                    errorMessage(getString(R.string.errorMessageWrongPassword));
                    return;
                }
                // sample code
//                tvError.setText("Welcome, " + username);
//                tvError.setVisibility(View.VISIBLE);
                Intent intent = new Intent(MainActivity.this,Home.class);
                startActivity(intent);
                finish();
            }
        });

        //move to register page
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRegister = new Intent(MainActivity.this, Register.class);
                startActivity(toRegister);
                finish();
            }
        });
    }

    //function to show error message
    public void errorMessage(String errorMsg) {
        tvError.setText(errorMsg);
        tvError.setVisibility(View.VISIBLE);
    }
}
