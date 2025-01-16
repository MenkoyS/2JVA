public class UserSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Search for a user: ");

        System.out.println("How do you want to search for a user?");

        System.out.println("1. Search by pseudo");
        System.out.println("2. Search by email");
        System.out.println("3. Search by store affiliation");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Search by pseudo: ");
                // TODO: Implement search by pseudo
                break;
            case 2:
                System.out.println("Search by email: ");
                // TODO: Implement search by email
                break;
            case 3:
                System.out.println("Search by store affiliation: ");
                // TODO: Implement search by store affiliation
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}