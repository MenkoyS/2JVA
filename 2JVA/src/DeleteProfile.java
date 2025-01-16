public class DeleteProfile {
    public static void main(String[] args) {
        System.out.println("Delete Profile: ");

        System.out.println("Are you sure you want to delete your profile? ");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Please enter your password to confirm: ");
                // Verify password, if correct, delete profile, else say the password is incorrect and ask again if 3 times wrong, return back to profile
                break;
            case 2:
                System.out.println("Profile not deleted, returning back to profile");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}