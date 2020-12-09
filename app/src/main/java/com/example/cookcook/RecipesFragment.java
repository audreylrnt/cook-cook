package com.example.cookcook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecipesFragment extends Fragment {
    RecyclerView rvRecipe;
    RecipeRVAdapter adapter;
    public RecipesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);
        rvRecipe = view.findViewById(R.id.rvRecipe);
        adapter = new RecipeRVAdapter(getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvRecipe.setLayoutManager(layoutManager);
        rvRecipe.setAdapter(adapter);
        return view;
    }
}