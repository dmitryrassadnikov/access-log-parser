package oopintro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.net.MalformedURLException;

import static oopintro.ReadFromFile.readFromFile;

public class StartLogEntry {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\PATH\\access.log");
        List<String> lines = readFromFile(file);
        LogEntry logEntry = null;
        Statistics statistics = new Statistics();
        List<LocalDateTime> dates = new ArrayList<>();
        for (String line : lines) {
            logEntry = new LogEntry(line);
            //  System.out.println("Строка из лог-файла: " + logEntry);
            UserAgent userAgent = new UserAgent(logEntry.getUserAgent());
            // System.out.print("Операционная система: " + userAgent.getOperatingSystem() + "\n" + "Браузер:" + userAgent.getBrowser() + "\n");
            statistics.addEntry(logEntry);
            dates.add(logEntry.getDateTime());
            statistics.addReferer(logEntry.getReferer());
        }
        LocalDateTime minTime = Collections.min(dates);
        LocalDateTime maxTime = Collections.max(dates);
        Duration duration = Duration.between(minTime, maxTime);
        long hoursDiff = duration.toHours();
        System.out.printf("Минимальная дата: %s\n", minTime);
        System.out.printf("Максимальная дата: %s\n", maxTime);
        System.out.println("Период времени в часах = " + hoursDiff);
        System.out.printf("Средний объем трафика за час: " + "%.2f\n", statistics.getTrafficRate() / hoursDiff);
        System.out.println("Статистика операционных систем пользователей сайта: " + statistics.getOperatingSystemsStatistics());
        System.out.println("Статистика браузеров пользователей сайта: " + statistics.getBrowserStatistics());
        System.out.println("Список всех существующих страниц сайта: " + statistics.getPages());
        System.out.println("Список всех несуществующих страниц сайта: " + statistics.getNonExistingPages());
        System.out.printf("Среднее количество посещений сайта за час: " + "%.2f\n", statistics.getAverageVisitsPerHour() / (double) hoursDiff);
        System.out.printf("Среднее количество ошибочных запросов в час: " + "%.2f\n", (double) hoursDiff / statistics.getAverageErrorRatePerHour());
        System.out.printf("Среднее количество посещений сайта в час одним пользователем: " + "%.2f\n", statistics.getAverageVisitsPerUser());
        System.out.println("Расчёт пиковой посещаемости сайта в секунду: " + statistics.getPeakVisitsPerSecond());
        System.out.println("Список сайтов, со страниц которых есть ссылки на текущий сайт : " + statistics.getReferringDomains());
        System.out.println("Расчёт максимальной посещаемости одним пользователем : " + statistics.getMaxVisitsByUser());
    }
}