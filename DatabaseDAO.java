package javaapplication33;

import java.sql.*;

public class DatabaseDAO {
    private Connection connection;
    private String url;
    private String username;
    private String password;

    public DatabaseDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void executeSelectQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("-------------------");
        }

        resultSet.close();
        statement.close();
    }

    public static void main(String[] args) {
        DatabaseDAO dao = new DatabaseDAO("jdbc:mysql://localhost:3305/mysql", "root", " ");
        try {
            dao.connect();
            String selectQuery = "SELECT * FROM users";
            dao.executeSelectQuery(selectQuery);
            dao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
