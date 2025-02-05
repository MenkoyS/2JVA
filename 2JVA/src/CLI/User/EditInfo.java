package CLI.User;

import Database.GenericSQLExecutor;
import java.util.List;
import java.util.Scanner;

public class EditInfo {

    public static void changeEmail(Scanner scanner, String idUser, String userName) {
        String newEmail = promptInput(scanner, "Enter new email: ");

        if (isAvailable("email", newEmail)) {
            updateUserField("email", newEmail, idUser);
            System.out.println("Email successfully changed.");
        } else {
            System.out.println("Email already exists.");
        }
        EditProfile.editUser(scanner, idUser, userName);
    }

    public static void changePassword(Scanner scanner, String idUser, String userName) {
        String newPassword = promptInput(scanner, "Enter new password: ");
        updateUserField("password", newPassword, idUser);
        System.out.println("Password successfully changed.");
        EditProfile.editUser(scanner, idUser, userName);
    }

    public static void changePseudo(Scanner scanner, String idUser, String userName) {
        String newPseudo = promptInput(scanner, "Enter new pseudo: ");

        if (isAvailable("pseudo", newPseudo)) {
            updateUserField("pseudo", newPseudo, idUser);
            System.out.println("Pseudo successfully changed.");
            userName = newPseudo;
        } else {
            System.out.println("Pseudo already exists.");
        }
        EditProfile.editUser(scanner, idUser, userName);
    }

    private static String promptInput(Scanner scanner, String message) {
        System.out.print(message);
        scanner.nextLine(); // Clear the buffer
        return scanner.nextLine();
    }

    private static boolean isAvailable(String field, String value) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery(
                "SELECT " + field + " FROM User WHERE " + field + " = ?", value
        );
        boolean available = rows == null || rows.isEmpty();
        System.out.println(available ? (field.toUpperCase() + " AVAILABLE") : (field.toUpperCase() + " ALREADY TAKEN"));
        return available;
    }

    private static void updateUserField(String field, String value, String idUser) {
        GenericSQLExecutor.executeQuery(
                "UPDATE User SET " + field + " = ? WHERE id = ?", value, idUser
        );
    }
}
