package Menus;

import Utils.LoginPageInteractions;
import Utils.LoginPageVerify;

import java.util.Scanner;

public class LoginPage {
    public static void main(Scanner scanner) {
        String[] userDetails = LoginPageInteractions.Login(scanner);
        LoginPageVerify.verify(scanner, userDetails);

    }
}
