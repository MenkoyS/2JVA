import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    static DBManager db = new DBManager("jdbc:mysql://localhost:3306/Auchan", "root", "root");

    public static void insertIntoDatabase(User user) {
        db.connect();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = db.getConnection();

            String sql = "INSERT INTO User (email, pseudo, password, isUser) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPseudo());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setBoolean(4, user.isIsUser());
            preparedStatement.executeUpdate();
            System.out.println("Insertion successful.");

        } catch (SQLException e) {
            System.out.println("Insertion failed" + e);
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close the connection: " + e);
            }
        }
    }
}
