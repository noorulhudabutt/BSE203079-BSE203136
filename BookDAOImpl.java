/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication38;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private Connection connection;

    public void connectToDatabase(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

    public void create(Book book) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO books (name, genre, price) VALUES (?, ?, ?)");
            statement.setString(1, book.getName());
            statement.setString(2, book.getGenre());
            statement.setDouble(3, book.getPrice());
            statement.executeUpdate();
            System.out.println("Book created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book read(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setPrice(resultSet.getDouble("price"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Book book) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE books SET name = ?, genre = ?, price = ? WHERE id = ?");
            statement.setString(1, book.getName());
            statement.setString(2, book.getGenre());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getId());
            statement.executeUpdate();
            System.out.println("Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Book deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setPrice(resultSet.getDouble("price"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/librarysystem?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String password = "";

        // Create an instance of BookDAOImpl
        BookDAOImpl bookDAO = new BookDAOImpl();

        // Initialize the connection
        bookDAO.connectToDatabase(url, username, password);

        // Perform CRUD operations
        Book book1 = new Book("Book 1", "Genre 1", 9.99);
        bookDAO.create(book1);

        Book book2 = bookDAO.read(1);
        if (book2 != null) {
            book2.setName("Updated Book");
            book2.setGenre("Updated Genre");
            book2.setPrice(14.99);
            bookDAO.update(book2);
        }

        bookDAO.delete(1);

        List<Book> books = bookDAO.getAllBooks();
        for (Book book : books) {
            System.out.println(book.getId() + ", " + book.getName() + ", " + book.getGenre() + ", " + book.getPrice());
        }
    }
}
