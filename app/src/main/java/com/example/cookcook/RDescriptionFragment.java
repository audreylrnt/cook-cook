package com.example.cookcook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RDescriptionFragment extends Fragment {
    TextView tvRecipeDesc;
    public RDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_r_description, container, false);
        int selectedId = SelectedRecipe.selectedRecipe.get(0);
        tvRecipeDesc = view.findViewById(R.id.detail_recipeDesc);
        tvRecipeDesc.setText(RecipeDB.recipeArrayList.get(selectedId).getRecipeDesc());
        return view;
    }
}