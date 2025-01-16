public class CreateNewUser {
    public static void main(String[] args) {
        System.out.println("Create a new account: ");

        System.out.println("Enter the email: ");
        String email = scanner.nextLine();

        // TODO : Check if the email is whitelisted

        // if the email is whitelisted then proceed

        if (email.isWhitelist) {
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            System.out.println("Confirm your password: ");
            String confirmPassword = scanner.nextLine();

            if (password.equals(confirmPassword)) {
                System.out.println("Enter your pseudo: ");
                String pseudo = scanner.nextLine();

                System.out.println("Do you want to connect to this new account ?");
                System.out.println("1. Yes");
                System.out.println("2. No");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // TODO : Call the function to connect to UserProfile with new args
                        break;
                    case 2:
                        // TODO : Comeback to profile menu
                        break;
                    default:
                        System.out.println("Invalid choice, returning to the profile menu");
                        // TODO : Comeback to profile menu
                }
            } else {
                System.out.println("Passwords do not match !");
                // TODO : Will need to create a new function so this function can be called again
            }
        }
    }
}