package Menus;

import Utils.LoginPageInteractions;
import Utils.LoginPageVerify;

import java.util.Scanner;

public class LoginPage {
    public static void main(Scanner scanner, boolean isGui) {
        String[] userDetails = LoginPageInteractions.Login(scanner, false);
        LoginPageVerify.verify(scanner, userDetails, false);

    }
}
