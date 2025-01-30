package Swing;

import Utils.LoginPageVerify;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class LoginPage {
    public static void displayLoginPage(int frameWidth, int frameHeight, Scanner scanner) {

        // Create a frame
        JFrame frame = new JFrame("iStore - Login Page");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Allows manual positioning

        // Create a label
        JLabel text = new JLabel("Login Form", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setBounds(0, 50, frameWidth, 50);

        // Back button (arrow image)
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(WelcomePage.class.getResource("arrow.png")));
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon arrow = new ImageIcon(scaledImage);
        JLabel arrowLabel = new JLabel(arrow);
        arrowLabel.setBounds(10, 10, 50, 50);
        arrowLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                WelcomePage.displayWelcomePage(frameWidth, frameHeight, scanner);
            }
        });

        // Create input fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);

        JTextField email = new JTextField();
        email.setFont(textFieldFont);
        email.setBounds(frameWidth / 2 - 100, 200, 200, 40);
        email.setHorizontalAlignment(JTextField.CENTER);

        JPasswordField password = new JPasswordField();
        password.setFont(textFieldFont);
        password.setBounds(frameWidth / 2 - 100, 300, 200, 40);
        password.setHorizontalAlignment(JTextField.CENTER);

        // Add a button to validate login
        JButton login = new JButton("Login");
        login.setBounds(frameWidth / 2 - 100, 400, 200, 50);

        // Action listener for the login button
        login.addActionListener(e -> {
            String emailInput = email.getText();
            String passwordInput = new String(password.getPassword()); // Use getPassword() for security
            String[] userDetails = {emailInput, passwordInput};
            LoginPageVerify.verify(scanner, userDetails, true);
            frame.dispose();
        });

        // Add components to the frame
        frame.add(arrowLabel);
        frame.add(text);
        frame.add(email);
        frame.add(password);
        frame.add(login);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
