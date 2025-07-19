package org.example;

import java.util.ArrayList;

public class AppService {
    ArrayList<String> mealCategory;
    ArrayList<String> mealName;
    ArrayList<String> ingredients;

    public AppService() {
        this.mealCategory = new ArrayList<String>();
        this.mealName = new ArrayList<String>();
        this.ingredients = new ArrayList<String>();
    }

    public ArrayList<String> getAllMealCategory() {
        return this.mealCategory;
    }

    public ArrayList<String> getAllMealName() {
        return this.mealName;
    }

    public ArrayList<String> getAllIngredients() {
        return this.ingredients;
    }

    public void addMealCategory(String mealCategory) {
        this.mealCategory.add(mealCategory);
    }

    public void addMealName(String mealName) {
        this.mealName.add(mealName);
    }

    public void addIngredients(String ingredients) {
        this.ingredients.add(ingredients);
    }

    public int getListLength() {
        return this.mealName.size();
    }


}
