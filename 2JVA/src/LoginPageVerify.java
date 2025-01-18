import java.util.List;
import java.util.Scanner;

public class LoginPageVerify {

    public static void verify(Scanner scanner, String[] userDetails, String[] args) {

        String email = userDetails[0];
        String password = userDetails[1];

        System.out.println(email);
        System.out.println(password);

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE email = ? AND password = ?", email, password);

        if (rows != null && !rows.isEmpty()) {
            System.out.println("You have successfully logged in");
            System.out.println("Redirecting you to your profile...");
            System.exit(0);
            // TODO : Call the homepage function
        } else {
            System.out.println("Invalid email or password");
            WelcomeMenu.main(args);
        }

    }
}
