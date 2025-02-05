package CLI.Admin;

import Database.GenericSQLExecutor;

import java.util.List;
import java.util.Scanner;

public class RemoveFromWhitelist {
    public static void removeUser(Scanner scanner) {
        System.out.println("Who do you want to remove from the whitelist ?");
        System.out.print("Please enter your choice : ");
        scanner.nextLine();
        String email = scanner.nextLine();
        List<GenericSQLExecutor.ResultSetRow> checkValidity = GenericSQLExecutor.executeQuery("SELECT * FROM Whitelist WHERE email = ?", email);
        if (checkValidity != null && !checkValidity.isEmpty()) {
            GenericSQLExecutor.executeQuery("DELETE FROM Whitelist WHERE email = ?", email);
            System.out.println(email + " deleted successfully");
        }
        else {
            System.out.println("No email found");
        }
        ManageWhitelist.reception(scanner);
    }
}
