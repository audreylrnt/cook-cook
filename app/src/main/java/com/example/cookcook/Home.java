package com.example.cookcook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    //Fragment fragment = null;
                    switch (item.getItemId()){
                        case R.id.logoutFragment:
                            //fragment = new LogoutFragment();
                            Intent intent = new Intent(Home.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                    }
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,fragment).commit();
                    return true;
                }
            };
}