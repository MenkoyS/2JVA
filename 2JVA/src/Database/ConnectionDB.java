package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    public ConnectionDB(String url, String username, String password) {
        this.url = "jdbc:mysql://localhost:3306/Auchan";
        this.username = "root";
        this.password = "root";
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the connection: " + e.getMessage());
        }
    }
}
