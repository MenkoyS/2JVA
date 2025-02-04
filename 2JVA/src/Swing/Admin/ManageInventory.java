package Swing.Admin;

import javax.swing.*;
import java.awt.*;

public class ManageInventory {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventory");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("INVENTORY", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        String[] buttonLabels = {"Add", "Remove", "Increase", "Decrease"};

        for (String text : buttonLabels) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setPreferredSize(new Dimension(150, 50));
            buttonPanel.add(button);
        }

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        for (int i = 1; i <= 20; i++) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            JLabel itemLabel = new JLabel("Item " + i, SwingConstants.CENTER);
            itemLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            itemPanel.add(itemLabel, BorderLayout.CENTER);
            itemPanel.setMaximumSize(new Dimension(600, 50));
            itemsPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(centerPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
