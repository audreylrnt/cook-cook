package com.example.cookcook;

public class Recipe {
    private int recipeName;
    private int recipeDesc;
    private int recipeDetail;
    private int recipeImg;

    public Recipe(int recipeName, int recipeDesc, int recipeDetail, int recipeImg) {
        this.recipeName = recipeName;
        this.recipeDesc = recipeDesc;
        this.recipeDetail = recipeDetail;
        this.recipeImg = recipeImg;
    }

    public int getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(int recipeName) {
        this.recipeName = recipeName;
    }

    public int getRecipeDesc() {
        return recipeDesc;
    }

    public void setRecipeDesc(int recipeDesc) {
        this.recipeDesc = recipeDesc;
    }

    public int getRecipeDetail() {
        return recipeDetail;
    }

    public void setRecipeDetail(int recipeDetail) {
        this.recipeDetail = recipeDetail;
    }

    public int getRecipeImg() {
        return recipeImg;
    }

    public void setRecipeImg(int recipeImg) {
        this.recipeImg = recipeImg;
    }
}
