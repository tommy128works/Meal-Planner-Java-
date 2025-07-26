package org.example;

import java.sql.*;
import java.util.ArrayList;

public class MealsDb {
    String DB_URL = "jdbc:postgresql://localhost:5432/meals_db";
    String USER = "postgres";
    String PASS = "1111";

    public MealsDb() {


    }

    void readMeal() {
        String sql = "SELECT * FROM ingredients";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createMeal(String category, String meal, ArrayList<String> ingredients) {
        // add category and meal to meals table
        // get the meal_id
        // add ingredients

        int mealId = 0;

        String sqlInsertMeal = "INSERT INTO meals (category, meal) VALUES (?, ?)";
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sqlInsertMeal, Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setString(1, category);
            pstmt.setString(2, meal);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            if (rowsInserted > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        mealId = rs.getInt("meal_id");
                        System.out.println("Generated meal_id: " + mealId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sqlInsertIngredients = "INSERT INTO ingredients (ingredient, meal_id) VALUES (?, ?)";
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sqlInsertIngredients);
        ) {
            conn.setAutoCommit(false);

            for (String item : ingredients) {
                pstmt.setString(1, item);
                pstmt.setInt(2, mealId);
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();
            System.out.println("Batch insert completed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
