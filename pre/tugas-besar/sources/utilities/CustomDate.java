package utilities;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CustomDate {
    public static Date stringToDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            return dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
