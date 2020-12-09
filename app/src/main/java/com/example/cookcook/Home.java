package com.example.cookcook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        Recipe recipe1 = new Recipe(R.string.recipe1name, R.string.recipe1desc, R.string.recipe1detail, R.drawable.tteokboki);
        Recipe recipe2 = new Recipe(R.string.recipe2name, R.string.recipe2desc, R.string.recipe2detail, R.drawable.chazuke);
        Recipe recipe3 = new Recipe(R.string.recipe3name, R.string.recipe3desc, R.string.recipe3detail, R.drawable.nasigoreng);
        if(RecipeDB.recipeArrayList.size() > 0) {
            RecipeDB.recipeArrayList.clear();
        }

        RecipeDB.recipeArrayList.add(recipe1);
        RecipeDB.recipeArrayList.add(recipe2);
        RecipeDB.recipeArrayList.add(recipe3);
        Intent getDetail = getIntent();
        if(getDetail.getStringExtra("flag") != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new RecipesFragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.recipesFragment);
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
        }
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected = null;
                    switch (item.getItemId()){
                        case R.id.homeFragment:
                            selected = new HomeFragment();
                            break;
                        case R.id.recipesFragment:
                            selected = new RecipesFragment();
                            break;
                        case R.id.logoutFragment:
                            selected = null;
                    }
                    if(selected != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selected).commit();
                    }
                    else {
                        Intent intent = new Intent(Home.this,MainActivity.class);
                        UserDB.users.clear();
                        startActivity(intent);
                        finish();
                    }
                    return true;
                }
            };
}