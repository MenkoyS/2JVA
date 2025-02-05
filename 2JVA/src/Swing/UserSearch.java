package Swing;

import javax.swing.*;
import java.awt.*;

import static Swing.LoginPage.createBackButton;

public class UserSearch {
    public static void main(String email, int frameWidth, int frameHeight) {

        // Create a frame
        JFrame frame = new JFrame("CLI.User Profile");
        frame.setSize(frameWidth, frameHeight); // Set the size of the frame

        // Set the close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label with the text "Welcome to your profile!"
        JLabel welcomeLabel = new JLabel("CLI.User Search", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font for the label
        // add padding
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        JLabel backButton = createBackButton(frame, () -> UserGUI.main(email,1200, 800));
        frame.add(backButton);

        // Create buttons
        JButton pseudoButton = new JButton("Search by Pseudo");

        // Add action listener to the button
        pseudoButton.addActionListener(_ -> {
            frame.dispose();
//            UserList.main(email, frameWidth, frameHeight, "pseudo");
        });

        JButton emailButton = new JButton("Search by Email");

        // Add action listener to the button
        emailButton.addActionListener(_ -> {
            frame.dispose();
//            UserList.main(email, frameWidth, frameHeight, "email");
        });

        JButton storeButton = new JButton("Search by Store Name");

        // Add action listener to the button
        storeButton.addActionListener(_ -> {
            frame.dispose();
//            UserList.main(email, frameWidth, frameHeight, "storeName");
        });

        // Set up a panel with a layout to add buttons below the label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        // Add the buttons to the panel
        buttonPanel.add(pseudoButton);
        buttonPanel.add(emailButton);
        buttonPanel.add(storeButton);

        // Set the layout for the frame's content pane
        frame.setLayout(new BorderLayout());
        frame.add(welcomeLabel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
