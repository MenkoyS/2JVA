import java.util.Scanner;

public class UserSearch {
    public static void main(Scanner scanner, String idUser, String userName) {

        System.out.println("Search for a user: ");

        System.out.println("1. Search by username (pseudo)");
        System.out.println("2. Search by email address");
        System.out.println("3. Search by store affiliation");
        System.out.println("4. Go back");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        SearchQueries.searchUser(choice, scanner, idUser, userName);
    }
}
