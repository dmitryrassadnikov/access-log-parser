package oopintro;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static oopintro.ReadFromFile.readFromFile;

public class MinMaxDate {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("c:\\PATH\\access3.log");
        List<String> lines = readFromFile(file);
        LogEntry logEntry = new LogEntry(lines.toString());
        System.out.println("Список: " + logEntry);
        System.out.println("Дата: " + logEntry.getDateTime());
        System.out.println("Минимальная дата: " + minDate(logEntry));
        System.out.println("Максимальная дата: " + maxDate(logEntry));
    }

    public static LocalDateTime minDate(LogEntry logEntry) {
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(logEntry.getDateTime());
        LocalDateTime minTime = dates.get(0);
        LocalDateTime maxTime = dates.get(0);
        for (LocalDateTime date : dates) {
            if (date.isBefore(minTime)) {
                minTime = date;
            }
            if (date.isAfter(maxTime)) {
                maxTime = date;
            }
        }
        System.out.println("Даты: " + dates);
        return minTime;
    }

    public static LocalDateTime maxDate(LogEntry logEntry) {
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(logEntry.getDateTime());
        LocalDateTime minTime = dates.get(0);
        LocalDateTime maxTime = dates.get(0);
        for (LocalDateTime date : dates) {
            if (date.isBefore(minTime)) {
                minTime = date;
            }
            if (date.isAfter(maxTime)) {
                maxTime = date;
            }
        }
        return maxTime;
    }
}






