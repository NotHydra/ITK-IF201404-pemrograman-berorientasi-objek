package utilities;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean match(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
