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
