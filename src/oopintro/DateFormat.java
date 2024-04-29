package oopintro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
    public static void main(String[] args) {
        String date_s = "[25/Sep/2022:06:25:04 +0300]";
        System.out.println(formatDate(date_s));
    }

    public static String formatDate(String date_s) {
        String result = "";
        SimpleDateFormat dt = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
        try {
            Date date = dt.parse(date_s);
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            result = dt1.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}




