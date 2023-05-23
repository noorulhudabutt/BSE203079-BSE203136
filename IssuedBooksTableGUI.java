/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication31;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IssuedBooksTableGUI extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public IssuedBooksTableGUI() {
        // Set up the JFrame
        setTitle("Issued Books Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("BID");
        tableModel.addColumn("USERNAME");
        tableModel.addColumn("ISSUE_DATE");
        tableModel.addColumn("DUE_DATE");

        // Create the table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addIssuedBook(String bid, String username, String issueDate, String dueDate) {
        tableModel.addRow(new Object[]{bid, username, issueDate, dueDate});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IssuedBooksTableGUI issuedBooksTableGUI = new IssuedBooksTableGUI();
                issuedBooksTableGUI.setVisible(true);

                // Add sample issued book data to the table
                issuedBooksTableGUI.addIssuedBook("1", "user1", "2023-05-01", "2023-05-15");
                issuedBooksTableGUI.addIssuedBook("2", "user2", "2023-05-03", "2023-05-17");
                issuedBooksTableGUI.addIssuedBook("3", "user3", "2023-05-05", "2023-05-19");
            }
        });
    }
}
