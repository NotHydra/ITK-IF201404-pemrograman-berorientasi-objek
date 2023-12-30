package providers;

import java.sql.*;

public class Database {
    private Connection connection;

    public Database() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean tableExist(String table) {
        try {
            return this.connection.getMetaData().getTables(null, null, table, null).next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int tableTotal(String table) {
        try {
            final ResultSet result = this.executeQuery("SELECT COUNT(*) AS `total` FROM " + table + ";");
            result.next();

            return result.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public ResultSet executeQuery(String query) {
        try {
            return this.connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeUpdate(String query) {
        try {
            this.connection.prepareStatement(query).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
