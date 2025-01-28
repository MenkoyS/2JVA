import java.util.List;
import java.util.Scanner;

public class ChangePseudo {
    public static void main(Scanner scanner, String idUser, String userName) {

        System.out.print("Enter new pseudo : ");
        scanner.nextLine();
        String choice = scanner.nextLine();
        int isTaken = isPseudoAvailable(choice);
        if (isTaken == 0) {
            GenericSQLExecutor.executeQuery("UPDATE User SET pseudo = ? WHERE id = ?", choice, idUser);
            System.out.println("Pseudo successfully changed");
        }
        else {
            System.out.println("Pseudo already exists");
        }
        EditProfile.main(scanner, idUser, userName);
    }

    public static int isPseudoAvailable(String pseudo) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT pseudo FROM User WHERE pseudo = '" + pseudo + "'");

        if (rows != null && !rows.isEmpty()) {
            System.out.println("PSEUDO ALREADY TAKEN");
            return 1;
        } else {
            System.out.println("PSEUDO AVAILABLE");
            return 0;
        }
    }
}
