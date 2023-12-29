package providers;

import java.sql.*;

public class Database {
    private Connection connection;

    public Database() throws SQLException {
        Dependency dependency = new Dependency();
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
                    + "major VARCHAR(255) "
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

    private boolean tableExist(String tableName) throws SQLException {
        return this.connection.getMetaData().getTables(null, null, tableName, null).next();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.connection.prepareStatement(query).executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        this.connection.prepareStatement(query).executeUpdate();
    }
}
