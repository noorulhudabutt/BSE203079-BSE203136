/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication30;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewUsers extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public ViewUsers() {
        // Set up the JFrame
        setTitle("User Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("UID");
        tableModel.addColumn("USERNAME");
        tableModel.addColumn("PASSWORD");
        tableModel.addColumn("ADMIN");

        // Create the table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addUser(String uid, String username, String password, String admin) {
        tableModel.addRow(new Object[]{uid, username, password, admin});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ViewUsers userTableGUI = new ViewUsers();
                userTableGUI.setVisible(true);

                // Add sample user data to the table
                userTableGUI.addUser("1", "user1", "pass1", "No");
                userTableGUI.addUser("2", "user2", "pass2", "Yes");
                userTableGUI.addUser("3", "user3", "pass3", "No");
            }
        });
    }
}

