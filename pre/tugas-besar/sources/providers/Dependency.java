package providers;

import io.github.cdimascio.dotenv.Dotenv;

public class Dependency {
    private final String databaseURL;
    private final String databaseUsername;
    private final String databasePassword;

    public Dependency() {
        final Dotenv environment = Dotenv.load();

        this.databaseURL = environment.get("DATABASE_URL");
        this.databaseUsername = environment.get("DATABASE_USERNAME");
        this.databasePassword = environment.get("DATABASE_PASSWORD");

        if (databaseURL == null || databaseURL.trim().isEmpty()) {
            throw new IllegalArgumentException("Database URL cannot be empty");
        }

        if (databaseUsername == null || databaseUsername.trim().isEmpty()) {
            throw new IllegalArgumentException("Database username cannot be empty");
        }

        if (databasePassword == null || databasePassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Database password cannot be empty");
        }
    }

    public String getDatabaseURL() {
        return this.databaseURL;
    }

    public String getDatabaseUsername() {
        return this.databaseUsername;
    }

    public String getDatabasePassword() {
        return this.databasePassword;
    }
}
