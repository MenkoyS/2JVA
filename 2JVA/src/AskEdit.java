import java.util.List;
import java.util.Scanner;

public class AskEdit {
    public static void main(Scanner scanner, String type, String idUser, String userName) {
        List<GenericSQLExecutor.ResultSetRow> userInfo = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ? OR email = ?", type, type);
        System.out.println("Here are the user's details: " + userInfo);
        System.out.println("What do you want to edit?");
        System.out.println("1. Pseudo");
        System.out.println("2. Email");
        System.out.println("3. Affiliation");
        System.out.println("4. Go back");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                EditInfo.changePseudo(type, scanner);
                break;
            case 2:
                EditInfo.changeEmail(type, scanner);
                break;
            case 3:
                EditInfo.changeAffiliation(type, scanner);
                break;
            case 4:
                AdminProfile.main(scanner, idUser, userName);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
