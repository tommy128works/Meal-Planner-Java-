package org.example;

import java.sql.*;

public class PgDatabase {

    public PgDatabase() throws SQLException {
        // The default PostgreSQL server port is 5432
        String DB_URL = "jdbc:postgresql://localhost:5432/person_db";
        String USER = "test456";
        String PASS = "1111";

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        connection.setAutoCommit(true);

        Statement statement = connection.createStatement();
        statement.executeUpdate("drop table if exists person");
        statement.executeUpdate("create table person (" +
                "id integer," +
                "name varchar(1024) NOT NULL" +
                ")");
        statement.executeUpdate("insert into person (id, name) values (1, 'leo')");
        statement.executeUpdate("insert into person (id, name) values (2, 'yui')");

        ResultSet rs = statement.executeQuery("select * from person");
        // Read the result set
        while (rs.next()) {
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
        }
        statement.close();
        connection.close();
    }


}
