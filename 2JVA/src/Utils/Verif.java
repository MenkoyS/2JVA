package Utils;

import Admin.AdminProfile;
import Database.DatabaseUtils;
import User.UserProfile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Verif {
    public static void isAdminLogin(String email, Scanner scanner, boolean isGui) {
        String isUser = DatabaseUtils.fetchSingleColumnValue("SELECT isUser FROM User WHERE email = ?", email);
        String idUser = DatabaseUtils.fetchSingleColumnValue("SELECT id FROM User WHERE email = ?", email);
        String userName = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE email = ?", email);

        assert isUser != null;
        if (isUser.equals("true") && !isGui) {
            UserProfile.main(scanner, idUser, userName, false);
        } else if (isUser.equals("true")) {
            // TODO : CALL GUI
        }
        else if (isUser.equals("false") && !isGui) {
            AdminProfile.main(scanner);
        } else if (isUser.equals("false")) {
            // TODO : CALL GUI
        } else
            System.out.println("Error");
    }

    public static void isAdmin(Scanner scanner, String idUser, String userName) {
        String isUser = DatabaseUtils.fetchSingleColumnValue("SELECT isUser FROM User WHERE id = ?", idUser);

        assert isUser != null;
        if (isUser.equals("0")) {
//            UserProfile.main(scanner, idUser, userName);
        } else if (isUser.equals("1")) {
            AdminProfile.main(scanner);
        } else
            System.out.println("Error");
    }

    public static int isEntryValid(int min, int max, Scanner scanner) {
        while (true) {
            try {
                int entry = scanner.nextInt();
                if (entry >= min && entry <= max) {
                    return entry;
                } else {
                    System.out.println("Entrée Invalide. Veuillez saisir un nombre entre " + min + " et " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez saisir un entier.");
                scanner.nextLine();
            }
        }
    }
}