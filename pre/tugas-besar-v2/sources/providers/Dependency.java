package providers;

import io.github.cdimascio.dotenv.Dotenv;

public class Dependency {
    private static Dependency instance;

    private Logger logger;
    private String databaseURL;
    private String databaseUsername;
    private String databasePassword;

    private Dependency(Logger logger) {
        this.logger = logger;

        final Dotenv environment = Dotenv.configure().load();
        this.databaseURL = environment.get("DATABASE_URL");
        this.databaseUsername = environment.get("DATABASE_USERNAME");
        this.databasePassword = environment.get("DATABASE_PASSWORD");

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
            try {
                Dependency.instance = new Dependency(new Logger(Dependency.class.getName()));
            } catch (IllegalArgumentException e) {
                Dependency.instance.logger.error(e.getMessage());

                throw e;
            } catch (Exception e) {
                Dependency.instance.logger.error("Failed to initialize Dependency instance");

                throw new RuntimeException("Failed to initialize Dependency instance");
            }
        }

        Dependency.instance.logger.debug("Get Instance");

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
