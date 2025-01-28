import java.util.List;
import java.util.Scanner;

public class AddToWhitelist {
    public static void main(Scanner scanner, String[] args) {
        String email;
        while (true) {
            email = checkCorrespondance(scanner, "email");
            int isTaken = isEmailAvailable(email);
            if (isTaken == 0) {
                break;
            }
        }
        int storeId = chooseStore(scanner);
        System.out.println("Here are the details: ");
        System.out.println("Email: " + email);
        System.out.println("Store id : " + storeId);

        System.out.println("You are adding " + email + " to the store " + storeId + ". Confirm?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int confirmChoice = scanner.nextInt();
        scanner.nextLine();

        if (confirmChoice == 1) {
            GenericSQLExecutor.executeQuery("INSERT INTO Whitelist (email, store_id) VALUES (?, ?)", email, storeId);
            System.out.println("Added to Whitelist");
        } else if (confirmChoice == 2) {
            System.out.println("Not added to Whitelist");
        } else {
            System.out.println("Invalid choice");
        }
        ManageWhitelist.main(scanner, args);
    }

    public static String checkCorrespondance(Scanner scanner, String inputName) {
        String input1;
        String input2;

        while (true) {
            System.out.println("Enter the " + inputName + ": ");
            input1 = scanner.nextLine().trim();

            if (input1.isEmpty()) {
                System.out.println(inputName + " cannot be empty. Please try again.");
                continue;
            }

            System.out.println("Confirm the " + inputName + ": ");
            input2 = scanner.nextLine().trim();

            if (!input1.equals(input2)) {
                System.out.println(inputName + "s do not match. Please try again.");
            } else {
                break;
            }
        }
        return input1;
    }

    public static int chooseStore(Scanner scanner) {
        System.out.println("Here is every store: ");
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM Store");
        if (rows != null) {for (GenericSQLExecutor.ResultSetRow row : rows) {System.out.println(row);}}
        System.out.println("Enter the store id: ");
        int storeId = scanner.nextInt();
        scanner.nextLine();
        return storeId;
    }

    public static int isEmailAvailable(String email) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT email FROM Whitelist WHERE email = '" + email + "'");

        if (rows != null && !rows.isEmpty()) {
            System.out.println("EMAIL ALREADY TAKEN");
            return 1;
        } else {
            System.out.println("EMAIL AVAILABLE");
            return 0;
        }
    }
}
