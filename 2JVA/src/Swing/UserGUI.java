package Swing;

import Database.DatabaseUtils;
import Database.GenericSQLExecutor;

import javax.swing.*;
import java.awt.*;

public class UserGUI {
    public static void main(String email, int frameWidth, int frameHeight) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("User Profile");
            frame.setSize(frameWidth, frameHeight);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel welcomeLabel = new JLabel("Welcome to your profile!", SwingConstants.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));

            JButton inventoryButton = new JButton("See the inventory");
            inventoryButton.addActionListener(_ -> {
                frame.dispose();
                SeeInventory.main(email, frameWidth, frameHeight);
            });

            JButton viewProfileButton = new JButton("View Profile");
            viewProfileButton.addActionListener(_ -> {
                frame.dispose();
                ViewProfile.main(email, frameWidth, frameHeight);
            });

            JButton searchUserButton = new JButton("Search for a user");
            searchUserButton.addActionListener(_ -> {
                frame.dispose();
                UserSearch.main(email, frameWidth, frameHeight);
            });

            JButton createAccountButton = new JButton("Create a new account");
            createAccountButton.addActionListener(_ -> {
                frame.dispose();
                CreateNewAcc.main(email, frameWidth, frameHeight);
            });

            JButton logoutButton = new JButton("Logout");
            logoutButton.addActionListener(_ -> {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    WelcomePage.displayWelcomePage(frameWidth, frameHeight);
                }
            });

            JButton deleteProfileButton = new JButton("Delete Profile");
            String storedPassword = DatabaseUtils.fetchSingleColumnValue("SELECT password FROM User WHERE email = ?", email);

            deleteProfileButton.addActionListener(_ -> {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your profile?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    JTextField emailField = new JTextField();
                    JPasswordField passwordField = new JPasswordField();
                    Object[] message = {"Enter your email:", emailField, "Enter your password:", passwordField};

                    if (JOptionPane.showConfirmDialog(null, message, "Profile Deletion - Verification", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                        String enteredEmail = emailField.getText();
                        String enteredPassword = new String(passwordField.getPassword());

                        if (enteredEmail.equals(email) && enteredPassword.equals(storedPassword)) {
                            GenericSQLExecutor.executeQuery("DELETE FROM User WHERE email = ? AND password = ?", enteredEmail, enteredPassword);
                            JOptionPane.showMessageDialog(null, "Profile deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            frame.dispose();
                            WelcomePage.displayWelcomePage(frameWidth, frameHeight);
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong credentials. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(6, 1, 10, 10));
            buttonPanel.add(inventoryButton);
            buttonPanel.add(viewProfileButton);
            buttonPanel.add(searchUserButton);
            buttonPanel.add(createAccountButton);
            buttonPanel.add(logoutButton);
            buttonPanel.add(deleteProfileButton);

            frame.setLayout(new BorderLayout());
            frame.add(welcomeLabel, BorderLayout.NORTH);
            frame.add(buttonPanel, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}