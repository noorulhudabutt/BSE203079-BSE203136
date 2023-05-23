/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication38;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

public class IssuedBookDAOImpl implements IssuedBookDAO {
    private Connection connection;

    // Constructor to initialize the connection
    
    public void create(IssuedBook issuedBook) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO issued_books (bookId, userId, period, issueDate) VALUES (?, ?, ?, ?)");
            statement.setInt(1, issuedBook.getBookId());
            statement.setInt(2, issuedBook.getUserId());
            statement.setInt(3, issuedBook.getPeriod());
            statement.setString(4, issuedBook.getIssueDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public IssuedBook read(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM issued_books WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                IssuedBook issuedBook = new IssuedBook();
                issuedBook.setId(resultSet.getInt("id"));
                issuedBook.setBookId(resultSet.getInt("bookId"));
                issuedBook.setUserId(resultSet.getInt("userId"));
                issuedBook.setPeriod(resultSet.getInt("period"));
                issuedBook.setIssueDate(resultSet.getString("issueDate"));
                return issuedBook;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(IssuedBook issuedBook) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE issued_books SET bookId = ?, userId = ?, period = ?, issueDate = ? WHERE id = ?");
            statement.setInt(1, issuedBook.getBookId());
            statement.setInt(2, issuedBook.getUserId());
            statement.setInt(3, issuedBook.getPeriod());
            statement.setString(4, issuedBook.getIssueDate());
            statement.setInt(5, issuedBook.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM issued_books WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<IssuedBook> getAllIssuedBooks() {
        List<IssuedBook> issuedBooks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM issued_books");
            while (resultSet.next()) {
                IssuedBook issuedBook = new IssuedBook();
                issuedBook.setId(resultSet.getInt("id"));
                issuedBook.setBookId(resultSet.getInt("bookId"));
                issuedBook.setUserId(resultSet.getInt("userId"));
                issuedBook.setPeriod(resultSet.getInt("period"));
                issuedBook.setIssueDate(resultSet.getString("issueDate"));
                issuedBooks.add(issuedBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issuedBooks;
    }

    public static void main(String[] args) {
        // Create an instance of IssuedBookDAOImpl
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/mysql","root","");
            System.out.println("Connection Done");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Connection not Done");
        }
        IssuedBookDAOImpl issuedBookDAO = new IssuedBookDAOImpl();

        // Perform CRUD operations
        IssuedBook issuedBook1 = new IssuedBook(1, 1, 7, 7, "2023-05-20");
        issuedBookDAO.create(issuedBook1);

        IssuedBook issuedBook2 = issuedBookDAO.read(1);
        if (issuedBook2 != null) {
            issuedBook2.setBookId(2);
            issuedBook2.setUserId(2);
            issuedBook2.setPeriod(14);
            issuedBook2.setIssueDate("2023-05-25");
            issuedBookDAO.update(issuedBook2);
        }

        issuedBookDAO.delete(1);

        List<IssuedBook> issuedBooks = issuedBookDAO.getAllIssuedBooks();
        for (IssuedBook issuedBook : issuedBooks) {
            System.out.println(issuedBook.getId() + ", " + issuedBook.getBookId() + ", " + issuedBook.getUserId() + ", " + issuedBook.getPeriod() + ", " + issuedBook.getIssueDate());
        }
    }
}

