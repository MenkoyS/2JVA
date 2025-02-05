package CLI.Common;

import Utils.Verif;

import java.util.Scanner;

public class UserSearch {
    public static void searchUser(Scanner scanner, String idUser, String userName) {
        System.out.println("Search for a user:");
        displayMenu();
        handleUserChoice(scanner, idUser, userName);
    }

    private static void displayMenu() {
        System.out.println("1. Search by username (pseudo)");
        System.out.println("2. Search by email address");
        System.out.println("3. Search by store affiliation");
        System.out.println("4. Go back");
        System.out.print("Please enter your choice: ");
    }

    private static void handleUserChoice(Scanner scanner, String idUser, String userName) {
        int choice = Verif.getValidEntry(1, 4, scanner);
        SearchQueries.searchUser(choice, scanner, idUser, userName);
    }
}