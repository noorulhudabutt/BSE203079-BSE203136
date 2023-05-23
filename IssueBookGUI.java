/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueBookGUI extends JFrame {
    private JTextField bidField;
    private JTextField usernameField;
    private JTextField issueDateField;
    private JTextField dueDateField;

    public IssueBookGUI() {
        // Set up the JFrame
        setTitle("Issue Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create the main panel and set its layout
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create the labels
        JLabel bidLabel = new JLabel("BID:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel issueDateLabel = new JLabel("Issue Date:");
        JLabel dueDateLabel = new JLabel("Due Date:");

        // Create the text fields
        bidField = new JTextField(10);
        usernameField = new JTextField(10);
        issueDateField = new JTextField(10);
        dueDateField = new JTextField(10);

        // Create panel for each row to center the input fields
        JPanel bidPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel issueDatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel dueDatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Add the text fields to the centered panels
        bidPanel.add(bidField);
        usernamePanel.add(usernameField);
        issueDatePanel.add(issueDateField);
        dueDatePanel.add(dueDateField);

        // Add the labels and centered panels to the main panel
        mainPanel.add(bidLabel);
        mainPanel.add(bidPanel);
        mainPanel.add(usernameLabel);
        mainPanel.add(usernamePanel);
        mainPanel.add(issueDateLabel);
        mainPanel.add(issueDatePanel);
        mainPanel.add(dueDateLabel);
        mainPanel.add(dueDatePanel);

        // Create and add the issue button
        JButton issueButton = new JButton("Issue");
        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bid = bidField.getText();
                String username = usernameField.getText();
                String issueDate = issueDateField.getText();
                String dueDate = dueDateField.getText();

                // Perform the issue book operation here
                // You can implement your own logic to handle the book issuing process

                // Print the entered issue details
                System.out.println("BID: " + bid);
                System.out.println("Username: " + username);
                System.out.println("Issue Date: " + issueDate);
                System.out.println("Due Date: " + dueDate);

                // Reset the text fields after issuing
                bidField.setText("");
                usernameField.setText("");
                issueDateField.setText("");
                dueDateField.setText("");
            }
        });
        mainPanel.add(issueButton);

        // Add the main panel to the frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                IssueBookGUI issueBookGUI = new IssueBookGUI();
                issueBookGUI.setVisible(true);
            }
        });
    }
}
