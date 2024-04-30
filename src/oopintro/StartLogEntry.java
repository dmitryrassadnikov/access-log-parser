package oopintro;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static oopintro.ReadFromFile.readFromFile;

public class StartLogEntry {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("c:\\PATH\\access.log");
        List<String> lines = readFromFile(file);
        LogEntry logEntry = null;
        Statistics statistics = new Statistics();
        List<LocalDateTime> dates = new ArrayList<>();
        for (String line : lines) {
            logEntry = new LogEntry(line);
            System.out.println("Строка из лог-файла: " + logEntry);
            UserAgent userAgent = new UserAgent(logEntry.getUserAgent());
            System.out.print("Операционная система: " + userAgent.getOperatingSystem() + "\n" + "Браузер:" + userAgent.getBrowser() + "\n");
            statistics.addEntry(logEntry);
            dates.add(logEntry.getDateTime());
        }
       // System.out.println("Даты " + dates);
        LocalDateTime minTime = Collections.min(dates);
        LocalDateTime maxTime = Collections.max(dates);
        Duration duration = Duration.between(minTime, maxTime);
        long hoursDiff = duration.toHours();
        System.out.printf("Минимальная дата: %s\n", minTime);
        System.out.printf("Максимальная дата: %s\n", maxTime);
        System.out.println("Период времени в часах = " + hoursDiff);
        System.out.printf("Средний объем трафика за час: " + "%.1f", statistics.getTrafficRate() / hoursDiff);
    }
}