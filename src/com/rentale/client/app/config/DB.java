package com.rentale.client.app.config;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentale?serverTimezone=UTC", "admin", "admin");
        } catch (SQLException throwables) {
            System.out.println("Database Connection Failed");
            throwables.printStackTrace();
        }
        return connection;
    }

}
