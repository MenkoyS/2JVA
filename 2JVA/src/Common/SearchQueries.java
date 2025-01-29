package Common;

import User.UserProfile;

import java.util.Scanner;

public class SearchQueries {
    public static void searchUser(int choice, Scanner scanner, String idUser, String userName) {

        switch (choice) {
            case 1:
                SearchByUsername.searchByUsername(scanner);
                break;
            case 2:
                SearchByEmail.searchByEmail(scanner);
                break;
            case 3:
                SearchByStore.searchByStore(scanner);
                break;
            case 4:
                UserProfile.main(scanner, idUser, userName);
            default:
                System.out.println("Invalid choice");
                // TODO : recall to the function
        }
    }
}