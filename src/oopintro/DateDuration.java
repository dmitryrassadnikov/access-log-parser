package oopintro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDuration {
    public static void main(String[] args) {
        String date_s = "-999999999-01-01T00:00";
        System.out.println(formatDate(date_s));
    }

    public static String formatDate(String date_s) {
        String result = "";
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        try {
            Date date = dt.parse(date_s);
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            result = dt1.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}




