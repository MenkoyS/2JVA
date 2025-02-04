package Swing.Admin;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UserSearchSelection {
    public static void main(String[] args) {

        int frameWidth = 1200; // Width of the frame
        int frameHeight = 800; // Height of the frame
        // Create a frame
        JFrame frame = new JFrame("User Profile");
        frame.setSize(frameWidth, frameHeight); // Set the size of the frame

        // Set the close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label with the text "Welcome to your profile!"
        JLabel welcomeLabel = new JLabel("Welcome to your profile!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font for the label

        // Create buttons
        JButton inventoryButton = new JButton("-Find by Pseudo");
        JButton viewProfileButton = new JButton("Find by Email");

        // Set up a panel with a layout to add buttons below the label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10)); // 7 rows, 1 column, with padding between buttons

        // Add the buttons to the panel
        buttonPanel.add(inventoryButton);
        buttonPanel.add(viewProfileButton);


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
