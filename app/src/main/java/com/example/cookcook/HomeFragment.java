package com.example.cookcook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {
    TextView tvFullname;
    CarouselView carouselView;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        tvFullname = view.findViewById(R.id.tvFullname);
        carouselView = view.findViewById(R.id.carouselView);
        Log.d("FragmentHome", "size is: " + RecipeDB.recipeArrayList.size());
        carouselView.setPageCount(RecipeDB.recipeArrayList.size());
        carouselView.setImageListener(imageListener);
        tvFullname.setText(UserDB.users.get(0).getFullName());
        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(RecipeDB.recipeArrayList.get(position).getRecipeImg());
        }
    };
}