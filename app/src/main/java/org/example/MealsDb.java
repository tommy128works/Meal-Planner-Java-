package org.example;

import java.sql.*;
import java.util.ArrayList;

public class MealsDb {
    String DB_URL = "jdbc:postgresql://localhost:5432/meals_db";
    String USER = "postgres";
    String PASS = "1111";

    public MealsDb() throws SQLException {


    }

    void selectAll() {
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

        String sql = "INSERT INTO meals (category, meal) VALUES (?, ?)";
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, category);
            pstmt.setString(2, meal);

            int rowsInserted = pstmt.executeUpdate();

            System.out.println(rowsInserted + " row(s) inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // add all ingredients
    }

}
