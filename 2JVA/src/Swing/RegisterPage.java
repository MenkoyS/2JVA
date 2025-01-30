package Swing;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class RegisterPage {
    public static void displayRegisterPage(int frameWidth, int frameHeight, Scanner scanner) {

        // Create a frame
        JFrame frame = new JFrame("iStore - Register Page");

        // Set the size of the frame
        frame.setSize(frameWidth, frameHeight);

        // Set the frame to close when the close button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout to null for manual positioning
        frame.setLayout(null);

        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(WelcomePage.class.getResource("arrow.png")));
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon arrow = new ImageIcon(scaledImage);

        JLabel arrowLabel = new JLabel(arrow);
        arrowLabel.setBounds(10, 10, 50, 50);

        // Add an action listener to the button
        arrowLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                WelcomePage.displayWelcomePage(frameWidth, frameHeight, scanner);
            }
        });

        frame.add(arrowLabel);


        // Create a label with the text "Register Form"
        JLabel text = new JLabel("Register Form");
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setBounds(0, 50, frameWidth, 50); // Centered at the top

        // Common font for text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);

        // Create input fields
        JTextField pseudo = new JTextField();
        pseudo.setFont(textFieldFont);
        pseudo.setBounds(frameWidth / 2 - 100, 200, 200, 40);
        pseudo.setHorizontalAlignment(JTextField.CENTER); // Centers the input text

        JTextField email = new JTextField();
        email.setFont(textFieldFont);
        email.setBounds(frameWidth / 2 - 100, 300, 200, 40);
        email.setHorizontalAlignment(JTextField.CENTER);

        JPasswordField password = new JPasswordField();
        password.setFont(textFieldFont);
        password.setBounds(frameWidth / 2 - 100, 400, 200, 40);
        password.setHorizontalAlignment(JTextField.CENTER);

        JPasswordField confirmPassword = new JPasswordField();
        confirmPassword.setFont(textFieldFont);
        confirmPassword.setBounds(frameWidth / 2 - 100, 500, 200, 40);
        confirmPassword.setHorizontalAlignment(JTextField.CENTER);

        // Add components to the frame
        frame.add(text);
        frame.add(pseudo);
        frame.add(email);
        frame.add(password);
        frame.add(confirmPassword);

        // Add a register button
        JButton register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 20));
        register.setBounds(frameWidth / 2 - 100, 600, 200, 50);
        frame.add(register);

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
