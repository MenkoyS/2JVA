package Swing;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UserGUI {
    public static void main(int frameWidth, int frameHeight, Scanner scanner) {
        // Create a frame
        JFrame frame = new JFrame("User Profile");
        frame.setSize(frameWidth, frameHeight); // Set the size of the frame

        // Set the close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label with the text "Welcome to your profile!"
        JLabel welcomeLabel = new JLabel("Welcome to your profile!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font for the label

        // Create buttons
        JButton inventoryButton = new JButton("See the inventory");
        JButton viewProfileButton = new JButton("View Profile");
        JButton editProfileButton = new JButton("Edit Profile");
        JButton searchUserButton = new JButton("Search for a user");
        JButton createAccountButton = new JButton("Create a new account");
        JButton logoutButton = new JButton("Logout");
        JButton deleteProfileButton = new JButton("Delete Profile");

        // Set up a panel with a layout to add buttons below the label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 10, 10)); // 7 rows, 1 column, with padding between buttons

        // Add the buttons to the panel
        buttonPanel.add(inventoryButton);
        buttonPanel.add(viewProfileButton);
        buttonPanel.add(editProfileButton);
        buttonPanel.add(searchUserButton);
        buttonPanel.add(createAccountButton);
        buttonPanel.add(logoutButton);
        buttonPanel.add(deleteProfileButton);

        // Set the layout for the frame's content pane
        frame.setLayout(new BorderLayout());
        frame.add(welcomeLabel, BorderLayout.NORTH); // Add label at the top
        frame.add(buttonPanel, BorderLayout.CENTER); // Add buttons in the center

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
