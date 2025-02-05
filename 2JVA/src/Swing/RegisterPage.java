package Swing;

import Database.DatabaseUtils;
import Database.GenericSQLExecutor;

import javax.swing.*;
import java.awt.*;

import static Swing.LoginPage.createBackButton;

public class RegisterPage {
    public static void displayRegisterPage(int frameWidth, int frameHeight) {
        JFrame frame = new JFrame("iStore - Register Page");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel backButton = createBackButton(frame, () -> WelcomePage.displayWelcomePage(frameWidth, frameHeight));
        frame.add(backButton);

        JLabel text = new JLabel("Register Form", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setBounds(0, 50, frameWidth, 50);
        frame.add(text);

        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);

        JTextField pseudo = createPlaceholderTextField("Enter your pseudo", frameWidth, 200, textFieldFont);
        JTextField emailLabel = createPlaceholderTextField("Enter your email", frameWidth, 300, textFieldFont);
        JTextField password = createPlaceholderTextField("Enter your password", frameWidth, 400, textFieldFont);
        JTextField confirmPassword = createPlaceholderTextField("Confirm your password", frameWidth, 500, textFieldFont);

        String pseudoRegis = pseudo.getText();
        String emailRegis = emailLabel.getText();
        String passwordRegis = password.getText();
        String confirmPasswordRegis = confirmPassword.getText();

        frame.add(pseudo);
        frame.add(emailLabel);
        frame.add(password);
        frame.add(confirmPassword);

        JButton register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 20));
        register.setBounds(frameWidth / 2 - 100, 600, 200, 50);

        // Add an action listener to the button
        register.addActionListener(_ -> {
            String verifEmail = DatabaseUtils.fetchSingleColumnValue("SELECT email FROM Whitelist WHERE email = ?", emailRegis);

            if (verifEmail == null) {
                JOptionPane.showMessageDialog(null, "This email is not allowed to register", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (passwordRegis.equals(confirmPasswordRegis)) {
                    GenericSQLExecutor.executeQuery("INSERT INTO User (pseudo, email, password) VALUES (?, ?, ?)", pseudoRegis, emailRegis, passwordRegis);
                    GenericSQLExecutor.executeQuery("DELETE FROM Whitelist WHERE email = ?", emailRegis);
                    JOptionPane.showMessageDialog(null, "Account created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    LoginPage.displayLoginPage(frameWidth, frameHeight);
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }});

        frame.add(register);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JTextField createPlaceholderTextField(String placeholder, int frameWidth, int y, Font font) {
        JTextField textField = new JTextField(placeholder);
        textField.setFont(font);
        textField.setBounds(frameWidth / 2 - 100, y, 200, 40);
        textField.setHorizontalAlignment(JTextField.CENTER);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });

        return textField;
    }
}