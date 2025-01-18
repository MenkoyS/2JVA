import java.util.Scanner;

public class UserSearch {
    public static void main(Scanner scanner) {

        System.out.println("Search for a user: ");

        System.out.println("How do you want to search for a user?");
        System.out.println("1. Search by username (pseudo)");
        System.out.println("2. Search by email address");
        System.out.println("3. Search by store affiliation");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        SearchQueries.searchUser(choice, scanner);
    }
}
