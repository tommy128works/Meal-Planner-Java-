package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppService {
//    ArrayList<String> mealCategory;
//    ArrayList<String> mealName;
//    ArrayList<String> ingredients;

    MealsDb db;

    public AppService() {
//        this.mealCategory = new ArrayList<String>();
//        this.mealName = new ArrayList<String>();
//        this.ingredients = new ArrayList<String>();

        try {
            this.db = new MealsDb();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getAllMealCategory() {
//        return this.mealCategory;
        return null;
    }

    public ArrayList<String> getAllMealName() {
//        return this.mealName;
        return null;
    }

    public ArrayList<String> getAllIngredients() {
//        return this.ingredients;
        return null;
    }

    public void createMeal(String mealCategory, String mealName,
                           ArrayList<String> ingredients) {
        // call db method to save in meal_db meals table and ingredients table
        this.db.createMeal(mealCategory, mealName, ingredients);
    }

    public ArrayList<String> convertStringToArrayList(String text) {
        ArrayList<String> list = new ArrayList<String>();
        for (String word : text.split(",")) {
            list.add(word.trim());
        }
        return list;
    }


//    public void addMealCategory(String mealCategory) {
//        this.mealCategory.add(mealCategory);
//    }

//    public void addMealName(String mealName) {
//        this.mealName.add(mealName);
//    }

//    public void addIngredients(String ingredients) {
//        this.ingredients.add(ingredients);
//    }

//    public int getListLength() {
//        return this.mealName.size();
//    }


}
