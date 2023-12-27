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
    }

    public void close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return this.connection.prepareStatement(query).executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        this.connection.prepareStatement(query).executeUpdate();
    }
}
