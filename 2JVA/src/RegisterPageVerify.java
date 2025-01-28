import java.util.List;
import java.util.Scanner;

public class RegisterPageVerify {

    public static void verify(Scanner scanner, String[] userDetails) {

        String pseudo = userDetails[0];
        String email = userDetails[1];
        String password = userDetails[2];
        String passwordAgain = userDetails[3];

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM Whitelist WHERE email = ?", email);

        if (rows != null && !rows.isEmpty()) {
            if (password.equals(passwordAgain)) {
                GenericSQLExecutor.executeQuery("INSERT INTO User (email, pseudo, password, isUser) VALUES (?, ?, ?, ?)", email, pseudo, password, 1);
                GenericSQLExecutor.executeQuery("DELETE FROM Whitelist WHERE email = ?", email);
            } else {
                System.out.println("Passwords do not match");
                // temp
            }
        } else {
            System.out.println("Email is not whitelisted, please contact the administrator");
            // temp
        }
    }
}
