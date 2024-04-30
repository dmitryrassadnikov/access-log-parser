package compare;

import oopintro.LogEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static oopintro.ReadFromFile.readFromFile;

public class DateTimeExample {
    public static void main(String[] args) throws FileNotFoundException {

        // System.out.println(Arrays.toString(datesArray));
        File file = new File("c:\\PATH\\access3.log");
        List<String> lines = readFromFile(file);
        LogEntry logEntry = null;
        List<LocalDateTime> dates = new ArrayList<>();


        for (String line : lines) {
            logEntry = new LogEntry(line);
            dates.add(logEntry.getDateTime());
        }
        System.out.println("ТЕСТ " + dates);
        LocalDateTime min = dates.get(0);
        System.out.println("min" + min);
        LocalDateTime max = dates.get(0);
        System.out.println("max" + max);
        for (LocalDateTime date : dates) {
            if (date.isBefore(min)) {
                min = date;
            }
            if (date.isAfter(max)) {
                max = date;
            }
        }

        LocalDateTime minDate = Collections.min(dates);
        LocalDateTime maxDate = Collections.max(dates);
        System.out.printf("Минимальная дата: %s\n", minDate);
        System.out.printf("Максимальная дата: %s\n", maxDate);
        System.out.printf("Минимальная дата: %s\n", min);
        System.out.printf("Максимальная дата: %s\n", max);
    }
}


