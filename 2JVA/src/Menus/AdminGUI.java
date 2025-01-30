package Swing;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class AdminGUI {
    public static void main(int frameWidth, int frameHeight, Scanner scanner) {
        // Create a frame
        JFrame frame = new JFrame("Admin Profile");
        frame.setSize(frameWidth, frameHeight); // Set the size of the frame

        // Set the close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label with the text "Welcome to your profile!"
        JLabel welcomeLabel = new JLabel("Welcome to your profile!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font for the label


        // Create buttons
        JButton inventoryButton = new JButton("Manage the inventory");
        JButton viewProfileButton = new JButton("Manage Users");
        JButton searchUserButton = new JButton("Manage Whitelist");
        JButton createAccountButton = new JButton("Manage Stores");
        JButton logoutButton = new JButton("Logout");

        // Set up a panel with a layout to add buttons below the label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 7 rows, 1 column, with padding between buttons

        // Add the buttons to the panel
        buttonPanel.add(inventoryButton);
        buttonPanel.add(viewProfileButton);
        buttonPanel.add(searchUserButton);
        buttonPanel.add(createAccountButton);
        buttonPanel.add(logoutButton);

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
