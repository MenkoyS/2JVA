package User;
import Database.GenericSQLExecutor;

import java.util.Scanner;

public class ChangePassword {
    public static void main(Scanner scanner, String idUser, String userName) {

        System.out.print("Enter new password : ");
        scanner.nextLine();
        String choice = scanner.nextLine();
        GenericSQLExecutor.executeQuery("UPDATE User SET password = ? WHERE id = ?", choice, idUser);

        EditProfile.main(scanner, idUser, userName);
    }
}
