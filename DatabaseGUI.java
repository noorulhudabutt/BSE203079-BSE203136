/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseGUI extends JFrame {

    private JLabel dbNameLabel;
    private JTextField dbNameTextField;
    private JButton createButton;
    private JButton resetButton;
    private DatabaseDAO databaseDAO;

    public DatabaseGUI() {
        // Set up the frame
        setTitle("Database GUI");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Initialize components
        dbNameLabel = new JLabel("Database Name:");
        dbNameTextField = new JTextField(20);
        createButton = new JButton("Create Database");
        resetButton = new JButton("Reset Database");

        // Add components to the frame
        add(dbNameLabel);
        add(dbNameTextField);
        add(createButton);
        add(resetButton);

        // Create DAO instance
        databaseDAO = new DatabaseDAO();

        // Add action listeners
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbName = dbNameTextField.getText();
                // Call DAO method to create database
                databaseDAO.createDatabase(dbName);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbName = dbNameTextField.getText();
                // Call DAO method to reset database
                databaseDAO.resetDatabase(dbName);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DatabaseGUI().setVisible(true);
            }
        });
    }
}
