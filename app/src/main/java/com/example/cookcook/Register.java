package com.example.cookcook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    Button btnLogin, btnRegister;
    EditText etFullName, etUsername, etPassword;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        etFullName = findViewById(R.id.etFullname);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvError = findViewById(R.id.tvErrorMsg);

        //styling & show/hide error message
        tvError.setVisibility(View.INVISIBLE);
        etFullName.getBackground().setAlpha(50);
        etUsername.getBackground().setAlpha(50);
        etPassword.getBackground().setAlpha(50);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validation
                String fullname = etFullName.getText() + "";
                String username = etUsername.getText() + "";
                String password = etPassword.getText() + "";

                if(username.equals("") || password.equals("") || fullname.equals("")){
                    errorMessage(getString(R.string.errorMessageEmpty));
                    return;
                }
                if(username.length() < 6) {
                    errorMessage(getString(R.string.errorMessageWrongUsernameLength));
                    return;
                }
                if(password.length() < 6) {
                    errorMessage(getString(R.string.errorMessageWrongPasswordLength));
                    return;
                }
                createAlert(fullname, username, password);
            }
        });

        //move to login page
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(Register.this, MainActivity.class);
                startActivity(toLogin);
                finish();
            }
        });
    }
    //function to show error message
    public void errorMessage(String errorMsg) {
        tvError.setText(errorMsg);
        tvError.setVisibility(View.VISIBLE);
    }

    //will run if validation passed
    public void createAlert(final String fullname, final String username, final String password) {
        AlertDialog.Builder alert = new AlertDialog.Builder(Register.this);
        alert.setMessage("Your data will be registered and you will be redirected to the login page.").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //pressed yes, data added to ArrayList
                User user = new User(username, fullname, password);
                UserDB.users.add(user);
                Intent toLogin = new Intent(Register.this, MainActivity.class);
                startActivity(toLogin);
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //pressed no, dialog vanish
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.setTitle("Confirm Registration?");
        alertDialog.show();
    }
}
