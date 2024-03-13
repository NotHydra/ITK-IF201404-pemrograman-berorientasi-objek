package providers;

import java.sql.*;

public class Database {
    private static Database instance;
    private static Connection connection;

    private Database() {
    }

    public static Database getInstance() {
        if (Database.instance == null) {
            try {
                Database.connection = DriverManager.getConnection(
                        Dependency.getInstance().getDatabaseURL(),
                        Dependency.getInstance().getDatabaseUsername(),
                        Dependency.getInstance().getDatabasePassword());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Database.instance;
    }

    public void close() {
        try {
            if (Database.connection != null && !Database.connection.isClosed()) {
                Database.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableForeignKey() {
        Database.instance.executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
    }

    private boolean tableExist(String table) {
        try {
            return Database.connection.getMetaData().getTables(null, null, table, null).next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int tableTotal(String table) {
        try {
            final ResultSet result = Database.instance.executeQuery("SELECT COUNT(*) AS `total` FROM " + table + ";");
            result.next();

            return result.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public ResultSet executeQuery(String query) {
        try {
            return Database.connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeUpdate(String query) {
        try {
            Database.connection.prepareStatement(query).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
