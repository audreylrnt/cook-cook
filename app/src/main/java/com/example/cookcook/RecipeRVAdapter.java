package com.example.cookcook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeRVAdapter extends RecyclerView.Adapter<RecipeRVAdapter.ViewHolder> {
    Context context;

    public RecipeRVAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeRVAdapter.ViewHolder holder, final int position) {
        Recipe recipe = RecipeDB.recipeArrayList.get(position);
        holder.tvRecipeName.setText(recipe.getRecipeName());
        holder.tvRecipeDesc.setText(recipe.getRecipeDesc());
        holder.recipeImg.setImageResource(recipe.getRecipeImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipeDetail = new Intent(context, RecipeDetail.class);
                if(SelectedRecipe.selectedRecipe.size() > 0) {
                    SelectedRecipe.selectedRecipe.clear();
                }
                SelectedRecipe.selectedRecipe.add(position);
                context.startActivity(toRecipeDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return RecipeDB.recipeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recipeImg;
        TextView tvRecipeName;
        TextView tvRecipeDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImg = itemView.findViewById(R.id.list_recipeimage);
            tvRecipeName = itemView.findViewById(R.id.list_recipename);
            tvRecipeDesc = itemView.findViewById(R.id.list_recipedesc);
        }
    }
}
