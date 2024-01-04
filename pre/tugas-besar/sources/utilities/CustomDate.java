package utilities;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CustomDate {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToDate(String date) {
        try {

            return dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String dateToString(Date date) {
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
