package Swing.User;

import Swing.UserGUI;

import javax.swing.*;
import java.awt.*;

import static Swing.LoginPage.createBackButton;

public class CreateNewAcc {
    public static void main(String email, int frameWidth, int frameHeight) {
        JFrame frame = new JFrame("iStore - Register Page");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel backButton = createBackButton(frame, () -> UserGUI.main(email, frameWidth, frameHeight));
        frame.add(backButton);

        JLabel text = new JLabel("Register Form", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setBounds(0, 50, frameWidth, 50);
        frame.add(text);

        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);

        JTextField pseudo = createPlaceholderTextField("Enter your pseudo", frameWidth, 200, textFieldFont);
        String NewPseudo = pseudo.getText();
        JTextField emailLabel = createPlaceholderTextField("Enter your email", frameWidth, 300, textFieldFont);
        String NewEmail = emailLabel.getText();
        JTextField password = createPlaceholderTextField("Enter your password", frameWidth, 400, textFieldFont);
        String NewPassword = password.getText();
        JTextField confirmPassword = createPlaceholderTextField("Confirm your password", frameWidth, 500, textFieldFont);
        String NewConfirmPassword = confirmPassword.getText();

        frame.add(pseudo);
        frame.add(emailLabel);
        frame.add(password);
        frame.add(confirmPassword);

        JButton register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 20));
        register.setBounds(frameWidth / 2 - 100, 600, 200, 50);

        register.addActionListener(_ -> {
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Would you like to login with this new account?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.out.println(NewEmail);
                UserGUI.main(NewEmail, frameWidth, frameHeight);
            } else {
                UserGUI.main(email, frameWidth, frameHeight);
            }
        });


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