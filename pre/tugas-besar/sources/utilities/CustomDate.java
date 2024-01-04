package utilities;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CustomDate {
    private static final SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat stringFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Date sqlToDate(String date) {
        try {

            return sqlFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String dateToSQL(Date date) {
        try {
            return sqlFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String dateToString(Date date) {
        try {
            return stringFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
