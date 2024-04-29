package oopintro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat2 {
    public static void main(String[] args) throws ParseException {
        String dateTime = "26/Sep/2022:10:18:33 +0300";
        SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        Date date = format.parse(dateTime);
        System.out.println(date);
    }
}




