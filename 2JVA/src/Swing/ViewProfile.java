package Swing;

import Utils.LoginPageVerify;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class ViewProfile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int frameWidth = 1200;
        int frameHeight = 800;

        // Create a frame
        JFrame frame = new JFrame("iStore - Login Page");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Allows manual positioning

        // Create a label
        JLabel text = new JLabel("Your Profile", SwingConstants.CENTER);
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setBounds(0, 50, frameWidth, 50);

        // Back button (arrow image)
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(WelcomePage.class.getResource("arrow.png")));
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon arrow = new ImageIcon(scaledImage);
        JLabel arrowLabel = new JLabel(arrow);
        arrowLabel.setBounds(10, 10, 50, 50);
        arrowLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                WelcomePage.displayWelcomePage(frameWidth, frameHeight, scanner);
            }
        });

        // Back button (arrow image)
        ImageIcon basedpfp = new ImageIcon(Objects.requireNonNull(WelcomePage.class.getResource("pfp.png")));
        Image scaledpfp = basedpfp.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon pfp = new ImageIcon(scaledpfp);
        JLabel pfplabel = new JLabel(pfp);
        pfplabel.setBounds(500, 100, 200, 200);

        // Create input fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);

        JTextField pseudo = new JTextField();
        pseudo.setFont(textFieldFont);
        pseudo.setBounds(frameWidth / 2 - 100, 300, 200, 40);
        pseudo.setText("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
        pseudo.setEditable(false);
        pseudo.setHorizontalAlignment(JTextField.CENTER);

        JTextField email = new JTextField();
        email.setFont(textFieldFont);
        email.setBounds(frameWidth / 2 - 100, 400, 200, 40);
        email.setEditable(false);
        email.setHorizontalAlignment(JTextField.CENTER);

        JPasswordField password = new JPasswordField();
        password.setFont(textFieldFont);
        password.setBounds(frameWidth / 2 - 100, 500, 200, 40);
        password.setEditable(false);
        password.setHorizontalAlignment(JTextField.CENTER);


        // Add components to the frame
        frame.add(arrowLabel);
        frame.add(pfplabel);
        frame.add(text);
        frame.add(pseudo);
        frame.add(email);
        frame.add(password);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
