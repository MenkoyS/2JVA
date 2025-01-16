public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setEmail("zpaedaef0");
        user.setPseudo("zpazd");
        user.setPassword("zpfeqfn0");
        user.setIsUser(false);

        DBManager dbManager = new DBManager("jdbc:mysql://localhost:3306/Auchan", "root", "root");
        dbManager.connect();

        UserRepository.insertIntoDatabase(user);

        dbManager.closeConnection();
    }
}