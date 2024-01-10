package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    private static final Random random = new Random();

    public static <Type> Type pickArray(Type[] array) {
        return array[random.nextInt(array.length)];
    }

    public static <Type> Type pickEnum(Class<Type> enumClass) {
        return enumClass.getEnumConstants()[random.nextInt(enumClass.getEnumConstants().length)];
    }

    public static String date(String start, String end) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            return dateFormat.format(
                    new Date(
                            ThreadLocalRandom.current().nextLong(
                                    dateFormat.parse(start).getTime(),
                                    dateFormat.parse(end).getTime())));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static char character() {
        return (char) ('A' + random.nextInt(26));
    }
}
