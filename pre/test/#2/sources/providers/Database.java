package providers;

import java.sql.*;

public class Database {
    private final Connection connection;

    public Database() throws SQLException {
        final Dependency dependency = new Dependency();
        this.connection = DriverManager.getConnection(
                dependency.getDatabaseURL(),
                dependency.getDatabaseUsername(),
                dependency.getDatabasePassword());

        if (!this.tableExist("student")) {
            this.executeUpdate("" +
                    "CREATE TABLE student ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "grade VARCHAR(255), "
                    + "major VARCHAR(255)"
                    + ");");

            this.executeUpdate("" +
                    "INSERT INTO student (name, grade, major) VALUES "
                    + "('Student 1', 'Grade 1', 'Major 1'), "
                    + "('Student 2', 'Grade 2', 'Major 2'), "
                    + "('Student 3', 'Grade 3', 'Major 3')"
                    + ";");
        }
    }

    public void close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }

    private boolean tableExist(String table) throws SQLException {
        return this.connection.getMetaData().getTables(null, null, table, null).next();
    }

    public int tableTotal(String table) throws SQLException {
        final ResultSet result = this.executeQuery("SELECT COUNT(*) AS `total` FROM " + table + ";");
        result.next();

        return result.getInt("total");
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.connection.prepareStatement(query).executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        this.connection.prepareStatement(query).executeUpdate();
    }
}
