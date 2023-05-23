/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {
    private JButton viewBooksButton;
    private JButton viewUsersButton;
    private JButton viewIssuedBooksButton;
    private JButton issueBookButton;
    private JButton addUserButton;
    private JButton addBookButton;
    private JButton returnBookButton;
    private JButton createResetButton;

    public AdminGUI() {
        // Set up the JFrame
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 130);
        setLocationRelativeTo(null);

        // Create the main panel and set its layout
        JPanel mainPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create the buttons
        viewBooksButton = new JButton("View Books");
        viewUsersButton = new JButton("View Users");
        viewIssuedBooksButton = new JButton("View Issued Books");
        issueBookButton = new JButton("Issue Book");
        addUserButton = new JButton("Add User");
        addBookButton = new JButton("Add Book");
        returnBookButton = new JButton("Return Book");
        createResetButton = new JButton("Create/Reset");

        // Add action listeners to the buttons
        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to view books
            }
        });

        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to view users
            }
        });

        viewIssuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to view issued books
            }
        });

        issueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to issue a book
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to add a user
            }
        });

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to add a book
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to return a book
            }
        });

        createResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to create/reset functionality
            }
        });

        // Add the buttons to the main panel
        mainPanel.add(viewBooksButton);
        mainPanel.add(viewUsersButton);
        mainPanel.add(viewIssuedBooksButton);
        mainPanel.add(issueBookButton);
        mainPanel.add(addUserButton);
        mainPanel.add(addBookButton);
        mainPanel.add(returnBookButton);
        mainPanel.add(createResetButton);

        // Add the main panel to the frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdminGUI adminGUI = new AdminGUI();
                adminGUI.setVisible(true);
            }
        });
    }
}
