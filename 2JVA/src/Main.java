public class Main {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager("jdbc:mysql://localhost:3306/Ikea", "root", "root");
        dbManager.connect();

        dbManager.closeConnection();
    }
}