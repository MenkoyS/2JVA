import java.util.Scanner;

public class WelcomeMenu {
    public static void main(Scanner scanner) {
        System.out.println("Hello");

        System.out.println("Would you like to launch the app using CLI or Swing GUI ?");

        System.out.println("1. CLI");
        System.out.println("2. Swing GUI");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                GuiMenu.main(scanner);
                break;
            case 2:
                System.out.println("Swing GUI");
                // lancer le swing qu'on va faire après
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
