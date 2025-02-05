package Swing;

import Database.DatabaseUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static Swing.LoginPage.createBackButton;

public class ViewProfile {
    public static void main(String email, int frameWidth, int frameHeight) {

        // Create a frame
        JFrame frame = new JFrame("iStore - Login Page");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Allows manual positioning

        // Create a label
        JLabel text = new JLabel("Your Profile", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setBounds(0, 50, frameWidth, 50);

        JLabel backButton = createBackButton(frame, () -> UserGUI.main(email,1200, 800));
        frame.add(backButton);


        // Back button (arrow image)
        ImageIcon basedpfp = new ImageIcon(Objects.requireNonNull(WelcomePage.class.getResource("pfp.png")));
        Image scaledpfp = basedpfp.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon pfp = new ImageIcon(scaledpfp);
        JLabel pfplabel = new JLabel(pfp);
        pfplabel.setBounds(500, 100, 200, 200);

        // Create input fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);

        JTextField pseudoLabel = new JTextField();
        pseudoLabel.setFont(textFieldFont);
        pseudoLabel.setBounds(frameWidth / 2 - 100, 300, 200, 40);
        String pseudo = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE email = ?", email);
        pseudoLabel.setText(pseudo);
        pseudoLabel.setHorizontalAlignment(JTextField.CENTER);

        JTextField emailLabel = new JTextField();
        emailLabel.setFont(textFieldFont);
        emailLabel.setBounds(frameWidth / 2 - 100, 400, 200, 40);
        emailLabel.setEditable(false);
        emailLabel.setText(email);
        emailLabel.setHorizontalAlignment(JTextField.CENTER);

        JTextField storeNameLabel = new JTextField();
        storeNameLabel.setFont(textFieldFont);
        storeNameLabel.setBounds(frameWidth / 2 - 100, 500, 200, 40);
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM User WHERE email = ?", email);
        String storeName = DatabaseUtils.fetchSingleColumnValue("SELECT name FROM Store WHERE store_id = ?", storeId);
        storeNameLabel.setText(storeName);
        storeNameLabel.setEditable(false);
        storeNameLabel.setHorizontalAlignment(JTextField.CENTER);


        // Add components to the frame
        frame.add(pfplabel);
        frame.add(text);
        frame.add(pseudoLabel);
        frame.add(emailLabel);
        frame.add(storeNameLabel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
