import java.util.List;

public class CreateNewUserVerify {
    public static void isWhitelist(String email) {

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT email FROM Whitelist WHERE email = '" + email + "'");

        if (rows != null && !rows.isEmpty()) {
            System.out.println("WHITELISTED");
        } else {
            System.out.println("NOT WHITELISTED");
            // TODO : Return to the profile menu
        }
    }

    public static void isPasswordCorresponding(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            System.out.println("PASSWORDS MATCH");
        } else {
            System.out.println("PASSWORDS DO NOT MATCH");
            // TODO : Return to the profile menu
        }
    }

    public static void isPseudoAvailable(String pseudo) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = '" + pseudo + "'");

        if (rows != null && !rows.isEmpty()) {
            System.out.println("PSEUDO ALREADY TAKEN");
            // TODO : Return to the profile menu
        } else {
            System.out.println("PSEUDO AVAILABLE");
        }
    }
}