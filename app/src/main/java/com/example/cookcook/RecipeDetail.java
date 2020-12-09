package com.example.cookcook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class RecipeDetail extends AppCompatActivity {
    Button btnBack;
    TextView tvRecipename;
    ImageView recipeImg;
    AppBarLayout appBarLayout;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Intent fromRV = getIntent();
        int position = fromRV.getIntExtra("position", 0);
        Log.d("Detail", "position: " + position);
        appBarLayout = findViewById(R.id.appbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        btnBack = findViewById(R.id.btnBack);
        tvRecipename = findViewById(R.id.detail_recipeName);
        recipeImg = findViewById(R.id.detail_recipeImg);
        tvRecipename.setText(RecipeDB.recipeArrayList.get(position).getRecipeName());
        recipeImg.setImageResource(RecipeDB.recipeArrayList.get(position).getRecipeImg());

        TabViewPagerAdapter tabViewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager());
        tabViewPagerAdapter.addFragment(new RDescriptionFragment(), "About Recipe");
        tabViewPagerAdapter.addFragment(new RDetailFragment(), "Instruction");
        viewPager.setAdapter(tabViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(RecipeDetail.this, Home.class);
                back.putExtra("flag", "fromRecipeDetail");
                startActivity(back);
                finish();
            }
        });

    }
}