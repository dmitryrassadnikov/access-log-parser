package oopintro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static oopintro.ReadFromFile.readFromFile;

public class StartLogEntry2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("c:\\PATH\\access3.log");
        List<String> lines = readFromFile(file);
        LogEntry logEntry = null;
        Statistics2 statistics = null;
        double traffic = 0;
        statistics = new Statistics2();
        for (String line : lines) {
            logEntry = new LogEntry(line);
            statistics.addEntry(logEntry);
            System.out.println("Строка из лог-файла: " + logEntry);
            UserAgent userAgent = new UserAgent(logEntry.getUserAgent());
            System.out.print("Операционная система: " + userAgent.getOperatingSystem() + "\n" + "Браузер:" + userAgent.getBrowser() + "\n");

            //traffic += logEntry.getContentLength();
            // traffic += statistics.getra();
            //  dates.add(logEntry.getDateTime());
           /* System.out.println("Минимальная дата: " + minDate(logEntry));
            System.out.println("Максимальная дата: " + maxDate(logEntry));*/
            //   System.out.println("statistics: " + statistics.);
            // System.out.println("Дата: " + logEntry.getDateTime());
            System.out.println("Трафик: " + statistics.getTrafficRate());
        }
        //  System.out.println("Даты: " + dates);
        //  System.out.println("Общий трафик: " + traffic);
        System.out.println("Общий трафик: " + statistics.getTrafficRate());
        //  System.out.println("Cредний объём трафика сайта за час: " + statistic.getTrafficRate());
    }
}


