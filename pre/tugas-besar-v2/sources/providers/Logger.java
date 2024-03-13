package providers;

public class Logger {
    @SuppressWarnings("unused")
    private static final Logger instance = new Logger("Logger");

    private final String context;

    public Logger(String context) {
        this.context = context;
    }

    public void info(String message) {
        System.out.println("[" + this.context + "][info] " + message);
    }

    public void debug(String message) {
        System.out.println("[" + this.context + "][debug] " + message);
    }

    public void warn(String message) {
        System.out.println("[" + this.context + "][warn] " + message);
    }

    public void error(String message) {
        System.err.println("[" + this.context + "][error] " + message);
    }

}
