import java.util.List;

public class DatabaseUtils {

    /**
     * Fetches a single column value from the database using the given query and parameter.
     *
     * @param query SQL query string with placeholders.
     * @param param Parameter to be substituted in the query.
     * @return Extracted value as a string or null if not found.
     */

    public static String fetchSingleColumnValue(String query, String param) {
        List<GenericSQLExecutor.ResultSetRow> rows = GenericSQLExecutor.executeQuery(query, param); // Execute query

        // Check if empty
        if (rows == null || rows.isEmpty()) {
            return null; // if empty, return null
        }
        // Extract value
        return ExtractValue.extractValue(rows.toString());
    }
}