package CLI.Admin;

import Database.GenericSQLExecutor;
import Utils.Verif;

import java.util.List;
import java.util.Scanner;

public class AskEdit {
    public static void editReception(Scanner scanner, String type) {
        List<GenericSQLExecutor.ResultSetRow> userInfo = fetchUserInfo(type);
        displayUserInfo(userInfo);
        handleEditChoice(scanner, type);
    }

    private static List<GenericSQLExecutor.ResultSetRow> fetchUserInfo(String type) {
        return GenericSQLExecutor.executeQuery(
                "SELECT * FROM User WHERE pseudo = ? OR email = ?", type, type);
    }

    private static void displayUserInfo(List<GenericSQLExecutor.ResultSetRow> userInfo) {
        System.out.println("Here are the user's details: " + userInfo);
        System.out.println("What do you want to edit?");
        System.out.println("1. Pseudo");
        System.out.println("2. Email");
        System.out.println("3. Affiliation");
        System.out.println("4. Go back");
    }

    private static void handleEditChoice(Scanner scanner, String type) {
        int choice = Verif.getValidEntry(1, 4, scanner);
        switch (choice) {
            case 1 -> EditInfo.changePseudo(type, scanner);
            case 2 -> EditInfo.changeEmail(type, scanner);
            case 3 -> EditInfo.changeAffiliation(type, scanner);
            case 4 -> AdminProfile.reception(scanner);
            default -> {
                System.out.println("Invalid choice. Please try again.");
                handleEditChoice(scanner, type);
            }
        }
    }
}
