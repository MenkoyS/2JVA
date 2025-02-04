package Swing;

import Database.DatabaseUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Swing.LoginPage.createBackButton;

public class SeeInventory {
    public static void main(String email, int frameWidth, int frameHeight) {
        String storeAffiliated = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE email = ?", email);

        JFrame frame = new JFrame("Inventory");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("INVENTORY", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        JLabel backButton = createBackButton(frame, () -> UserGUI.main(email,frameWidth, frameHeight));
        frame.add(backButton);

        // Fetch all names, quantities, and prices separately
        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<String> itemQuantities = new ArrayList<>();
        ArrayList<String> itemPrices = new ArrayList<>();

        // Fetching items one by one
        for (int i = 0; ; i++) {
            String name = DatabaseUtils.fetchSingleColumnValue("SELECT name FROM Inventory WHERE store_id = ? LIMIT 1 OFFSET " + i, storeAffiliated);
            String quantity = DatabaseUtils.fetchSingleColumnValue("SELECT quantity FROM Inventory WHERE store_id = ? LIMIT 1 OFFSET " + i, storeAffiliated);
            String price = DatabaseUtils.fetchSingleColumnValue("SELECT price FROM Inventory WHERE store_id = ? LIMIT 1 OFFSET " + i, storeAffiliated);

            if (name == null || quantity == null || price == null) break; // Stop when no more data

            itemNames.add(name);
            itemQuantities.add(quantity);
            itemPrices.add(price);
        }

        // Display items
        int size = itemNames.size();
        for (int i = 0; i < size; i++) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridLayout(1, 3, 10, 10));
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel("Name: " + itemNames.get(i), SwingConstants.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
            itemPanel.add(nameLabel);

            JLabel quantityLabel = new JLabel("Quantity: " + itemQuantities.get(i), SwingConstants.CENTER);
            quantityLabel.setFont(new Font("Arial", Font.BOLD, 24));
            itemPanel.add(quantityLabel);

            JLabel priceLabel = new JLabel("Price: " + itemPrices.get(i) + "$", SwingConstants.CENTER);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 24));
            itemPanel.add(priceLabel);

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
