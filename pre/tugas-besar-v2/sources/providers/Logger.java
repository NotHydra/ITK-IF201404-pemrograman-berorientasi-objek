package providers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final Logger instance = new Logger("Logger");

    private final String context;

    public Logger(String context) {
        this.context = context;
    }

    public static Logger getInstance() {
        return instance;
    }

    private String currentTimestamp() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return currentTime.format(formatter);
    }

    public void info(String message) {
        System.out.println("[" + this.currentTimestamp() + "][" + this.context + "][info] " + message);
    }

    public void debug(String message) {
        System.out.println("[" + this.currentTimestamp() + "][" + this.context + "][debug] " + message);
    }

    public void warn(String message) {
        System.out.println("[" + this.currentTimestamp() + "][" + this.context + "][warn] " + message);
    }

    public void error(String message) {
        System.err.println("[" + this.currentTimestamp() + "][" + this.context + "][error] " + message);
    }

}
