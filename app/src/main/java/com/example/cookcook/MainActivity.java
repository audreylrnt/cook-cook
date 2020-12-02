package com.example.cookcook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        tvError.setVisibility(View.INVISIBLE);
        etUsername.getBackground().setAlpha(50);
        etPassword.getBackground().setAlpha(50);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText() + "";
                String password = etPassword.getText() + "";

                if(username.equals("") || password.equals("")){
                    errorMessage(getString(R.string.errorMessageEmpty));
                    return;
                }
                if(UserDB.users.size() == 0) {
                    errorMessage(getString(R.string.errorMessageIllegalLogin));
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
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    //function to show error message
    public void errorMessage(String errorMsg) {
        tvError.setText(errorMsg);
        tvError.setVisibility(View.VISIBLE);
    }
}
