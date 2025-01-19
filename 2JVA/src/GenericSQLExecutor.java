import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenericSQLExecutor {

    static ConnectionDB db = new ConnectionDB("jdbc:mysql://localhost:3306/Auchan", "root", "root");

    public static List<ResultSetRow> executeQuery(String sql, Object... params) {
        db.connect();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // Bind parameters
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            // Execute query
            if (sql.trim().toLowerCase().startsWith("select")) {
                resultSet = preparedStatement.executeQuery();
                return processResultSet(resultSet);
            } else {
                preparedStatement.executeUpdate();
                System.out.println("Query executed successfully.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("SQL execution failed: " + e);
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully.");
                }
            } catch (SQLException e) {
                System.out.println("Failed to close resources: " + e);
            }
        }
    }

    private static List<ResultSetRow> processResultSet(ResultSet resultSet) throws SQLException {
        List<ResultSetRow> rows = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            ResultSetRow row = new ResultSetRow();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);
                Object value = resultSet.getObject(i);
                row.addColumn(columnName, value);
            }
            rows.add(row);
        }
        return rows;
    }

    public static class ResultSetRow {
        private final List<Column> columns = new ArrayList<>();

        public void addColumn(String name, Object value) {
            columns.add(new Column(name, value));
        }

        public Object getValue(String columnName) {
            return columns.stream()
                    .filter(column -> column.getName().equals(columnName))
                    .findFirst()
                    .map(Column::getValue)
                    .orElse(null);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (Column column : columns) {
                sb.append(column.getName()).append(": ").append(column.getValue()).append(", ");
            }
            if (!columns.isEmpty()) sb.setLength(sb.length() - 2); // Remove trailing comma
            sb.append("}");
            return sb.toString();
        }

        private static class Column {
            private final String name;
            private final Object value;

            public Column(String name, Object value) {
                this.name = name;
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public Object getValue() {
                return value;
            }
        }
    }
}