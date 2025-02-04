package Swing.Admin;

import javax.swing.*;
import java.awt.*;

public class UserManage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Management");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("USER MANAGEMENT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        JLabel subTitleLabel = new JLabel("What would you like to change about a user?", SwingConstants.CENTER);
        subTitleLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel editButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        String[] editLabels = {"Pseudo", "Email", "Store Affiliation"};
        for (String text : editLabels) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setPreferredSize(new Dimension(200, 80));
            editButtonsPanel.add(button);
        }

        // Panel for displaying user information in a COLUMN
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column
        userInfoPanel.setBorder(BorderFactory.createEmptyBorder(30, 400, 30, 400)); // Center horizontally

        String[] userInfo = {"Pseudo: pseudoTest", "Email: emailTest", "Store: storeTest"};
        for (String info : userInfo) {
            JLabel label = new JLabel(info, SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 24));
            userInfoPanel.add(label);
        }

        JPanel actionButtonsPanel = new JPanel();
        actionButtonsPanel.setLayout(new BoxLayout(actionButtonsPanel, BoxLayout.Y_AXIS));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(subTitleLabel);
        centerPanel.add(editButtonsPanel);
        centerPanel.add(userInfoPanel);
        centerPanel.add(actionButtonsPanel);

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
