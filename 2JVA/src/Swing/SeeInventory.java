package Swing;

import javax.swing.*;
import java.awt.*;

public class SeeInventory {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventory");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("INVENTORY", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        for (int i = 1; i <= 20; i++) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            JLabel itemLabel = new JLabel("Item " + i);
            itemLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
            itemPanel.add(itemLabel, BorderLayout.CENTER);
            itemPanel.setMaximumSize(new Dimension(600, 50));
            itemsPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
