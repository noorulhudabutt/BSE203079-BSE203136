/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication36;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends JFrame implements ActionListener {
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField isbnField;

    public AddBook() {
        setTitle("Add Book Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create labels
        JLabel titleLabel = new JLabel("Title:");
        JLabel authorLabel = new JLabel("Author:");
        JLabel yearLabel = new JLabel("Publication Year:");
        JLabel isbnLabel = new JLabel("ISBN:");

        // Create text fields
        titleField = new JTextField(20);
        authorField = new JTextField(20);
        yearField = new JTextField(20);
        isbnField = new JTextField(20);

        // Create button
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(this);

        // Create panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        panel.add(titleLabel, gridBagConstraints);
        panel.add(authorLabel, gridBagConstraints);
        panel.add(yearLabel, gridBagConstraints);
        panel.add(isbnLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;

        panel.add(titleField, gridBagConstraints);
        panel.add(authorField, gridBagConstraints);
        panel.add(yearField, gridBagConstraints);
        panel.add(isbnField, gridBagConstraints);
        panel.add(addButton, gridBagConstraints);

        // Add panel to content pane
        Container contentPane = getContentPane();
        contentPane.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = titleField.getText();
        String author = authorField.getText();
        int year = Integer.parseInt(yearField.getText());
        String isbn = isbnField.getText();

        // Perform book addition logic here
        // ...

        // Display a message dialog to confirm successful addition
        JOptionPane.showMessageDialog(this, "Book added successfully!");

        // Clear the form after adding the book
        titleField.setText("");
        authorField.setText("");
        yearField.setText("");
        isbnField.setText("");
    }

    public static void main(String[] args) {
        AddBook addBookGUI = new AddBook();
        addBookGUI.setVisible(true);
    }
}

