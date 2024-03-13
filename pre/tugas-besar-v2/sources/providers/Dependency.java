package providers;

import io.github.cdimascio.dotenv.Dotenv;

public class Dependency {
    private static Dependency instance;

    private Logger logger;
    private String databaseURL;
    private String databaseUsername;
    private String databasePassword;

    private Dependency(Logger logger, String databaseURL, String databaseUsername, String databasePassword) {
        this.logger = logger;
        this.databaseURL = databaseURL;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;

        if (this.databaseURL == null || this.databaseURL.trim().isEmpty()) {
            throw new IllegalArgumentException("Database URL cannot be empty");
        }

        if (this.databaseUsername == null || this.databaseUsername.trim().isEmpty()) {
            throw new IllegalArgumentException("Database username cannot be empty");
        }

        if (this.databasePassword == null || this.databasePassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Database password cannot be empty");
        }
    };

    public static Dependency getInstance() {
        if (Dependency.instance == null) {
            final Dotenv environment = Dotenv.configure().load();

            Dependency.instance = new Dependency(
                    new Logger(Dependency.class.getName()),
                    environment.get("DATABASE_URL"),
                    environment.get("DATABASE_USERNAME"),
                    environment.get("DATABASE_PASSWORD"));

        }

        return Dependency.instance;
    }

    public String getDatabaseURL() {
        this.logger.debug("Get Database URL");

        return this.databaseURL;
    }

    public String getDatabaseUsername() {
        this.logger.debug("Get Database Username");

        return this.databaseUsername;
    }

    public String getDatabasePassword() {
        this.logger.debug("Get Database Password");

        return this.databasePassword;
    }
}
