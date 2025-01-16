import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        System.out.println("Inventory");

        System.out.println("1. Add item");
        System.out.println("2. List items");
        System.out.println("3. Change item quantity");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Add item");
                break;
            case 2:
                System.out.println("List items");
                break;
            case 3:
                System.out.println("Change item quantity");
                break;
            case 4:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}