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

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
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
        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
        alert.setMessage("Your data will be registered and you will be redirected to the login page.").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //pressed yes, data added to ArrayList
                User user = new User(username, fullname, password);
                UserDB.users.add(user);
                Intent toLogin = new Intent(RegisterActivity.this, MainActivity.class);
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