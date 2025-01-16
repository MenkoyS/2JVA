import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericSQLExecutor.executeQuery("INSERT INTO User (email, pseudo, password, isUser) VALUES (?, ?, ?, ?)", "john@example.com", "John", "password", true);

        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM User WHERE pseudo = ?", "John");
        if (rows != null) {
            for (GenericSQLExecutor.ResultSetRow row : rows) {
                System.out.println(row);
            }
        }
    }
}