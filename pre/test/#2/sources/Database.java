import java.sql.*;

public class Database {
    private Connection connection;

    public Database() throws SQLException {
        Dependency dependency = new Dependency();

        try {
            this.connection = DriverManager.getConnection(
                    dependency.getDatabaseURL(),
                    dependency.getDatabaseUsername(),
                    dependency.getDatabasePassword());
        } catch (SQLException e) {
            throw e;
        }
    }

    public void close() throws SQLException {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        try {
            return this.connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void executeUpdate(String query) throws SQLException {
        try {
            this.connection.prepareStatement(query).executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
}
