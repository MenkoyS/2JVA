import java.util.Scanner;

public class SearchQueries {
    public static void searchUser(int choice, Scanner scanner) {

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
            default:
                System.out.println("Invalid choice");
                // TODO : recall to the function
        }
    }
}