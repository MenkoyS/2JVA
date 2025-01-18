import java.util.List;

public class ViewWhitelist {
    public static void main(String[] args) {
        System.out.println("Here are the details: ");
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery("SELECT * FROM Whitelist");
        if (rows != null) {for (GenericSQLExecutor.ResultSetRow row : rows) {System.out.println(row);}}
    }
}
