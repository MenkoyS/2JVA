package Database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractValue {
    public static String extractValue(String queryResult) {
        // Step 1: Remove []
        queryResult = queryResult.replaceAll("[\\[\\]]", "");

        // Step 2: Remove {}
        queryResult = queryResult.replaceAll("[{}]", "");

        // Step 3: Remove column names
        queryResult = queryResult.replaceAll("store_id\\s*:", "");
        queryResult = queryResult.replaceAll("email\\s*:", "");
        queryResult = queryResult.replaceAll("pseudo\\s*:", "");
        queryResult = queryResult.replaceAll("name\\s*:", ""); // Added to remove 'name:'
        queryResult = queryResult.replaceAll("quantity\\s*:", ""); // Added to remove 'quantity:'
        queryResult = queryResult.replaceAll("price\\s*:", ""); // Added to remove 'price:'
        queryResult = queryResult.replaceAll("id\\s*:", ""); // Added to remove 'id:'
        queryResult = queryResult.replaceAll("isUser\\s*:", "");

        // Step 4: Extract the string value
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+|\\w+"); // Match email or alphanumeric strings
        Matcher matcher = pattern.matcher(queryResult);

        if (matcher.find()) {
            return matcher.group();
        }

        return null; // Return null if no match is found
    }
}
