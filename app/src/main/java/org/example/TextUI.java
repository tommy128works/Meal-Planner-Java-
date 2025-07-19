package org.example;

import java.util.Scanner;

public class TextUI {
    private final Scanner scanner;
    private final AppService service;

    public TextUI(AppService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
    }

    public void start() {
        this.askMealCategory();
        String mealCategory = this.receiveInput();
        this.askMealName();
        String mealName = this.receiveInput();
        this.askIngredients();
        String ingredients = this.receiveInput();
        System.out.println();
        this.printMeal(mealCategory, mealName, ingredients);
        System.out.println("The meal has been added!");
    }

    public void askMealCategory() {
        System.out.println("Which meal do you want to add " +
                "(breakfast, lunch, dinner)?");
    }

    public String receiveInput() {
        return this.scanner.nextLine();
    }

    public void askMealName() {
        System.out.println("Input the meal's name:");
    }

    public void askIngredients() {
        System.out.println("Input the ingredients:");
    }

    public void printMeal(String mealCategory, String mealName,
                          String ingredients) {
        System.out.println("Category " + mealCategory);
        System.out.println("Name: " + mealName);
        System.out.println("Ingredients:");
        for (String word : ingredients.split(",")) {
            System.out.println(word);
        }
    }

}
