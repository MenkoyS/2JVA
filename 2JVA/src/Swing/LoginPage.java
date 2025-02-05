package Swing;

import Utils.LoginPageVerify;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LoginPage {
    public static void displayLoginPage(int frameWidth, int frameHeight) {
        JFrame frame = createFrame(frameWidth, frameHeight);
        JLabel text = createLabel(frameWidth);
        JLabel arrowLabel = createBackButton(frame, () -> WelcomePage.displayWelcomePage(frameWidth, frameHeight));
        Font textFieldFont = new Font("Arial", Font.PLAIN, 18);

        JTextField email = createPlaceholderTextField("Enter your email", textFieldFont, frameWidth / 2 - 100, 200);
        JTextField password = createPlaceholderTextField("Enter your password", textFieldFont, frameWidth / 2 - 100, 300);

        JButton login = new JButton("Login");
        login.setBounds(frameWidth / 2 - 100, 400, 200, 50);
        login.addActionListener(_ -> {
            String[] userDetails = {email.getText(), password.getText()};
            System.out.println("Email: " + userDetails[0] + " Password: " + userDetails[1]);
            LoginPageVerify.verify(null, userDetails, true);
            frame.dispose();
        });

        frame.add(arrowLabel);
        frame.add(text);
        frame.add(email);
        frame.add(password);
        frame.add(login);
        frame.setVisible(true);
    }

    private static JFrame createFrame(int width, int height) {
        JFrame frame = new JFrame("iStore - Login Page");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private static JLabel createLabel(int width) {
        JLabel label = new JLabel("Login Form", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setBounds(0, 50, width, 50);
        return label;
    }

    public static JLabel createBackButton(JFrame frame, Runnable onClickAction) {
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(WelcomePage.class.getResource("arrow.png")));
        Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon arrow = new ImageIcon(scaledImage);
        JLabel arrowLabel = new JLabel(arrow);
        arrowLabel.setBounds(10, 10, 50, 50);

        arrowLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.dispose();
                onClickAction.run(); // Executes the specified action
            }
        });

        return arrowLabel;
    }


    private static JTextField createPlaceholderTextField(String placeholder, Font font, int x, int y) {
        JTextField textField = new JTextField(placeholder);
        textField.setFont(font);
        textField.setBounds(x, y, 200, 40);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
        return textField;
    }
}