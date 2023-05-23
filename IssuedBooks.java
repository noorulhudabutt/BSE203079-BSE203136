/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication29;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IssuedBooks extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public IssuedBooks() {
        // Set up the JFrame
        setTitle("Book Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("BID");
        tableModel.addColumn("BNAME");
        tableModel.addColumn("GENRE");
        tableModel.addColumn("PRICE");

        // Create the table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addBook(String bid, String bname, String genre, String price) {
        tableModel.addRow(new Object[]{bid, bname, genre, price});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IssuedBooks bookTableGUI = new IssuedBooks();
                bookTableGUI.setVisible(true);

                // Add sample book data to the table
                bookTableGUI.addBook("1", "Book A", "Fiction", "$10");
                bookTableGUI.addBook("2", "Book B", "Mystery", "$15");
                bookTableGUI.addBook("3", "Book C", "Romance", "$12");
            }
        });
    }
}
