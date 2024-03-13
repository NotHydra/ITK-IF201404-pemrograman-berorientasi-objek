package providers;

import io.github.cdimascio.dotenv.Dotenv;

public class Dependency {
    private static Dependency instance;

    private String databaseURL;
    private String databaseUsername;
    private String databasePassword;

    private Dependency() {
    };

    public static Dependency getInstance() {
        if (Dependency.instance == null) {
            Dependency.instance = new Dependency();

            final Dotenv environment = Dotenv.load();

            Dependency.instance.databaseURL = environment.get("DATABASE_URL");
            Dependency.instance.databaseUsername = environment.get("DATABASE_USERNAME");
            Dependency.instance.databasePassword = environment.get("DATABASE_PASSWORD");

            if (Dependency.instance.databaseURL == null || Dependency.instance.databaseURL.trim().isEmpty()) {
                throw new IllegalArgumentException("Database URL cannot be empty");
            }

            if (Dependency.instance.databaseUsername == null || Dependency.instance.databaseUsername.trim().isEmpty()) {
                throw new IllegalArgumentException("Database username cannot be empty");
            }

            if (Dependency.instance.databasePassword == null || Dependency.instance.databasePassword.trim().isEmpty()) {
                throw new IllegalArgumentException("Database password cannot be empty");
            }
        }

        return Dependency.instance;
    }

    public String getDatabaseURL() {
        return Dependency.instance.databaseURL;
    }

    public String getDatabaseUsername() {
        return Dependency.instance.databaseUsername;
    }

    public String getDatabasePassword() {
        return Dependency.instance.databasePassword;
    }
}
