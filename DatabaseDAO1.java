/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databasegui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.lang.model.SourceVersion;

public class DatabaseDAO1 {

    private Connection connection;

    public DatabaseDAO1() {
        // Initialize database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDatabase(String dbName) {
        // Implement your logic to create a database with the given name
        try {
            String sql = "CREATE DATABASE " + dbName;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Database created: " + dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void resetDatabase(String dbName) {
        // Implement your logic to reset the database with the given name
        try {
            String sql = "DROP DATABASE IF EXISTS " + dbName;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Database reset: " + dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



   










