package com.example.cookcook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RDetailFragment extends Fragment {
    TextView tvRecipeDetail;
    public RDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_r_detail, container, false);
        int selectedId = SelectedRecipe.selectedRecipe.get(0);
        tvRecipeDetail = view.findViewById(R.id.detail_recipeDetail);
        tvRecipeDetail.setText(RecipeDB.recipeArrayList.get(selectedId).getRecipeDetail());
        return view;
    }
}