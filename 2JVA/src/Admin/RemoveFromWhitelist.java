package Admin;

import Database.GenericSQLExecutor;

import java.util.List;
import java.util.Scanner;

public class RemoveFromWhitelist {
    public static void main(Scanner scanner) {
        System.out.println("Who do you want to remove from the whitelist ?");
        System.out.print("Please enter your choice : ");
        String email = scanner.nextLine();
        List<GenericSQLExecutor.ResultSetRow> checkValidity = GenericSQLExecutor.executeQuery("SELECT * FROM Whitelist WHERE email = ?", email);
        if (checkValidity != null && !checkValidity.isEmpty()) {
            GenericSQLExecutor.executeQuery("DELETE FROM Whitelist WHERE email = ?", email);
            System.out.println(email + " deleted successfully");
        }
        else {
            System.out.println("No email found");
        }
        ManageWhitelist.main(scanner);
    }
}
