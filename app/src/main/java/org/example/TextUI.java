package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private final Scanner scanner;
    private final AppService service;

    public TextUI(AppService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
    }

    public void start() {
        while (true) {
            this.askOperation();
            String operation = this.scanner.nextLine();

            if (operation.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            this.processOperation(operation);
        }
    }

//    private void printMeal(String mealCategory, String mealName,
//                          String ingredients) {
//        System.out.println("Category " + mealCategory);
//        System.out.println("Name: " + mealName);
//        System.out.println("Ingredients:");
//        for (String word : ingredients.split(",")) {
//            System.out.println(word.trim());
//        }
//    }

    private void askOperation() {
        System.out.println("What would you like to do " +
                "(add, show, exit)?");
    }

    private void processOperation(String operation) {
        switch (operation) {
            case "add":
                this.addMeal();
                break;
            case "show":
                this.showMeals();
                break;
        }
    }

    private void showMeals() {
        // need to get meal and category from meals table
        // get ingredients from ingredients table
        // print it all
        // i might be able to just iterate through ResultSet





//        int listLength = this.service.getListLength();
//        ArrayList<String> mealCategory = this.service.getAllMealCategory();
//        ArrayList<String> mealName = this.service.getAllMealName();
//        ArrayList<String> ingredients = this.service.getAllIngredients();
//
//        if (listLength == 0) {
//            System.out.println("No meals saved. Add a meal first.");
//            return;
//        }
//
//        System.out.println();
//        for (int i = 0; i < listLength; i++) {
//            printMeal(mealCategory.get(i), mealName.get(i), ingredients.get(i));
//            System.out.println();
//        }
    }

    private void addMeal() {
        System.out.println("Which meal do you want to add " +
                "(breakfast, lunch, dinner)?");
        String mealCategory;
        String mealName;
        String ingredients;

        while (true) {
            mealCategory = this.scanner.nextLine();
            if (mealCategory.equals("breakfast") || mealCategory.equals("lunch")
                    || mealCategory.equals("dinner")) {
//                this.service.addMealCategory(mealCategory);
                break;
            }
            System.out.println("Wrong meal category! " +
                    "Choose from: breakfast, lunch, dinner.");
        }

        System.out.println("Input the meal's name:");
        while (true) {
            mealName = this.scanner.nextLine();
            if (mealName.matches("[a-zA-Z, ]+")) {
//                this.service.addMealName(mealName);
                break;
            }
            System.out.println("Wrong format. Use letters only!");
        }

        System.out.println("Input the ingredients:");
        while (true) {
            ingredients = this.scanner.nextLine();
            if (ingredients.matches("[a-zA-Z, ]+")) {
//                this.service.addIngredients(ingredients);
                break;
            }
            System.out.println("Wrong format. Use letters only!");
        }

        // call service class to save to database
        ArrayList<String> ingredientsList = this.service.convertStringToArrayList(ingredients);
        this.service.createMeal(mealCategory, mealName, ingredientsList);

        System.out.println("The meal has been added!");
    }

}
