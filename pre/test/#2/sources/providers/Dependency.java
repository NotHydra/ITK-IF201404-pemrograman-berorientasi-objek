package providers;

import io.github.cdimascio.dotenv.Dotenv;

public class Dependency {
    private String databaseURL;
    private String databaseUsername;
    private String databasePassword;

    public Dependency() {
        Dotenv environment = Dotenv.load();

        this.databaseURL = environment.get("DATABASE_URL");
        this.databaseUsername = environment.get("DATABASE_USERNAME");
        this.databasePassword = environment.get("DATABASE_PASSWORD");
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
