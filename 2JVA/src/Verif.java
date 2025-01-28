import java.util.Scanner;

public class Verif {
    public static void isAdminLogin(String email, Scanner scanner) {
        String isUser = DatabaseUtils.fetchSingleColumnValue("SELECT isUser FROM User WHERE email = ?", email);
        String idUser = DatabaseUtils.fetchSingleColumnValue("SELECT id FROM User WHERE email = ?", email);
        String userName = DatabaseUtils.fetchSingleColumnValue("SELECT pseudo FROM User WHERE email = ?", email);


        assert isUser != null;
        if (isUser.equals("0")) {
            UserProfile.main(scanner, idUser, userName);
        } else if (isUser.equals("1")) {
            AdminProfile.main(scanner, idUser, userName);
        } else
            System.out.println("Error");
    }

    public static void isAdmin(Scanner scanner, String idUser, String userName) {
        String isUser = DatabaseUtils.fetchSingleColumnValue("SELECT isUser FROM User WHERE id = ?", idUser);

        assert isUser != null;
        if (isUser.equals("0")) {
            UserProfile.main(scanner, idUser, userName);
        } else if (isUser.equals("1")) {
            AdminProfile.main(scanner, idUser, userName);
        } else
            System.out.println("Error");
    }
}