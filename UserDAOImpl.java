/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication38;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    // Constructor to initialize the connection
    public UserDAOImpl() {
        // Initialize the connection here
    }

    public void create(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, password, isAdmin) VALUES (?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User read(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, password = ?, isAdmin = ? WHERE id = ?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        // Create an instance of UserDAOImpl
        UserDAOImpl userDAO = new UserDAOImpl();

        // Perform CRUD operations
        User user1 = new User("John Doe", "password123", false);
        userDAO.create(user1);

        User user2 = userDAO.read(1);
        if (user2 != null) {
            user2.setName("Jane Smith");
            user2.setPassword("newpassword456");
            user2.setAdmin(true);
            userDAO.update(user2);
        }

        userDAO.delete(1);

        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            System.out.println(user.getId() + ", " + user.getName() + ", " + user.getPassword() + ", " + user.isAdmin());
        }
    }
}
