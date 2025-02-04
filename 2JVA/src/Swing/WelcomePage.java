package Swing;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    public static void displayWelcomePage(int frameWidth, int frameHeight) {

        // Create a frame
        JFrame frame = new JFrame("iStore");

        // Set the size of the frame
        frame.setSize(frameWidth, frameHeight);

        // Set the frame to close when the close button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label with the text "Welcome to the application"
        JLabel text = new JLabel("Welcome to iStore");
        text.setFont(new Font("Arial", Font.BOLD, 36));

        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.TOP);

        // Add a bit of padding at the top of the label
        text.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

        // Add a button to the frame
        JButton register = new JButton("Register");
        register.setBounds(500, 300, 200, 50);

        // Add an action listener to the button
        register.addActionListener(_ -> {
            frame.dispose();
            RegisterPage.displayRegisterPage(frameWidth, frameHeight);
        });

        JButton login = new JButton("Login");
        login.setBounds(500, 400, 200, 50);

        // Add an action listener to the button
        login.addActionListener(_ -> {
            frame.dispose();
            LoginPage.displayLoginPage(frameWidth, frameHeight);
        });


        frame.add(register);
        frame.add(login);

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Add the label to the frame
        frame.add(text);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
