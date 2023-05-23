/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication37;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}

public class ReturnBook extends JFrame implements ActionListener {
    private JTextField isbnField;
    private Library library;

    public ReturnBook(Library library) {
        this.library = library;

        setTitle("Return Book Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create label
        JLabel isbnLabel = new JLabel("Enter ISBN:");

        // Create text field
        isbnField = new JTextField(20);

        // Create button
        JButton returnButton = new JButton("Return Book");
        returnButton.addActionListener(this);

        // Create panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(isbnLabel);
        panel.add(isbnField);
        panel.add(returnButton);

        // Add panel to content pane
        Container contentPane = getContentPane();
        contentPane.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String isbn = isbnField.getText();

        // Find the book in the library by ISBN
        Book foundBook = null;
        for (Book book : library.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                foundBook = book;
                break;
            }
        }

        if (foundBook != null) {
            // Remove the book from the library
            library.removeBook(foundBook);

            // Display a message dialog to confirm successful return
            JOptionPane.showMessageDialog(this, "Book returned successfully!");

            // Clear the form after returning the book
            isbnField.setText("");
        } else {
            // Display an error message if the book is not found
            JOptionPane.showMessageDialog(this, "Book not found!");
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        // Add some books to the library for testing
        library.addBook(new Book("Title 1", "Author 1", 2021, "ISBN1"));
        library.addBook(new Book("Title 2", "Author 2", 2022, "ISBN2"));

        ReturnBook returnBookGUI = new ReturnBook(library);
        returnBookGUI.setVisible(true);
    }
}
