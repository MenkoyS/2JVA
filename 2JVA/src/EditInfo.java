import java.util.List;
import java.util.Scanner;

public class EditInfo {
    public static void changePseudo(String type, Scanner scanner) {
        System.out.println("Enter the new pseudo: ");
        scanner.nextLine(); // buffer
        String newPseudo = scanner.next();

        // Find out if the search method returned a pseudo or an email
        List<GenericSQLExecutor.ResultSetRow> isTypePseudo = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ?", type);
        List<GenericSQLExecutor.ResultSetRow> isTypeEmail = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ?", type);

        if (isTypePseudo != null && !isTypePseudo.isEmpty()) {
            GenericSQLExecutor.executeQuery("UPDATE User SET pseudo = ? WHERE pseudo = ?", newPseudo, type);
            System.out.println("Pseudo updated to " + newPseudo);
        } else if (isTypeEmail != null && !isTypeEmail.isEmpty()) {
            GenericSQLExecutor.executeQuery("UPDATE User SET pseudo = ? WHERE email = ?", newPseudo, type);
            System.out.println("Pseudo updated to " + newPseudo);
        } else {
            System.out.println("Error: No user found with the provided pseudo or email.");
        }
    }

    public static void changeEmail(String type, Scanner scanner) {
        System.out.println("Enter the new email: ");
        scanner.nextLine(); // buffer
        String newEmail = scanner.next();

        // Find out if the search method returned a pseudo or an email
        List<GenericSQLExecutor.ResultSetRow> isTypePseudo = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ?", type);
        List<GenericSQLExecutor.ResultSetRow> isTypeEmail = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ?", type);

        if (isTypePseudo != null && !isTypePseudo.isEmpty()) {
            GenericSQLExecutor.executeQuery("UPDATE User SET email = ? WHERE pseudo = ?", newEmail, type);
            System.out.println("Email updated to " + newEmail);
        } else if (isTypeEmail != null && !isTypeEmail.isEmpty()) {
            GenericSQLExecutor.executeQuery("UPDATE User SET email = ? WHERE email = ?", newEmail, type);
            System.out.println("Email updated to " + newEmail);
        } else {
            System.out.println("Error: No user found with the provided pseudo or email.");
        }
    }

    public static void changeAffiliation(String type, Scanner scanner) {
        System.out.println("Enter the new affiliation: ");
        scanner.nextLine(); // buffer
        String affiliationName = scanner.next();

        // Get store_id for the given store name
        String storeId = DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM Store WHERE name = ?", affiliationName);

        if (storeId == null) {
            System.out.println("Store not found.");
            return;
        }

        // Find out if the search method returned a pseudo or an email
        List<GenericSQLExecutor.ResultSetRow> isTypePseudo = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ?", type);
        List<GenericSQLExecutor.ResultSetRow> isTypeEmail = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ?", type);

        if (isTypePseudo != null && !isTypePseudo.isEmpty()) {
            GenericSQLExecutor.executeQuery("UPDATE User SET store_id = ? WHERE pseudo = ?", storeId, type);
            System.out.println("Affiliation updated to " + affiliationName);
        } else if (isTypeEmail != null && !isTypeEmail.isEmpty()) {
            GenericSQLExecutor.executeQuery("UPDATE User SET store_id = ? WHERE email = ?", storeId, type);
            System.out.println("Affiliation updated to " + affiliationName);
        } else {
            System.out.println("Error: No user found with the provided pseudo or email.");
        }
    }
}
