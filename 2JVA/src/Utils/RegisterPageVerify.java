package Utils;

import Database.DatabaseUtils;
import Database.GenericSQLExecutor;

import java.util.List;

public class RegisterPageVerify {

    public static void verify(String[] userDetails) {
        String pseudo = userDetails[0];
        String email = userDetails[1];
        String password = userDetails[2];
        String passwordAgain = userDetails[3];

        if (!password.equals(passwordAgain)) {
            System.out.println("Passwords do not match");
            return;
        }

        if (!isEmailWhitelisted(email)) {
            System.out.println("Email is not whitelisted, please contact the administrator");
            return;
        }

        String storeId = getStoreId(email);
        registerUser(email, pseudo, password, storeId);
        removeFromWhitelist(email);
    }

    private static boolean isEmailWhitelisted(String email) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM Whitelist WHERE email = ?", email);
        return rows != null && !rows.isEmpty();
    }

    private static String getStoreId(String email) {
        return DatabaseUtils.fetchSingleColumnValue("SELECT store_id FROM Whitelist WHERE email = ?", email);
    }

    private static void registerUser(String email, String pseudo, String password, String storeId) {
        GenericSQLExecutor.executeQuery("INSERT INTO User (email, pseudo, password, isUser, store_id) VALUES (?, ?, ?, 1, ?)", email, pseudo, password, storeId);
        System.out.println("User registered successfully.");
    }

    private static void removeFromWhitelist(String email) {
        GenericSQLExecutor.executeQuery("DELETE FROM Whitelist WHERE email = ?", email);
        System.out.println("Email removed from whitelist.");
    }
}