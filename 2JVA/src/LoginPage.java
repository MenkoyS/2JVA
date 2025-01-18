import java.util.Scanner;

public class LoginPage {
    public static void main(Scanner scanner, String[] args) {

        String[] userDetails = LoginPageInteractions.Login(scanner);
        LoginPageVerify.verify(scanner, userDetails, args);

    }
}
