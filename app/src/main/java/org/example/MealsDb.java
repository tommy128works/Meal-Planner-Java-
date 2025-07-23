package org.example;

import java.sql.*;

public class MealsDb {

    public MealsDb() throws SQLException {
        String DB_URL = "jdbc:postgresql://localhost:5432/meals_db";
        String USER = "postgres";
        String PASS = "1111";

        String sql = "SELECT * FROM ingredients";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
//            conn.setAutoCommit(true);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
