package oopintro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static oopintro.ReadFromFile.readFromFile;

public class StartLogEntry {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("c:\\PATH\\access3.log");
        List<String> lines = readFromFile(file);
        for (String line : lines) {
            LogEntry logEntry = new LogEntry(line);
            System.out.println("Строка из лог-файла: " + logEntry);
            UserAgent userAgent = new UserAgent(logEntry.getUserAgent());
            System.out.print("Операционная система: " + userAgent.getOperatingSystem() + "\n" + "Браузер:" + userAgent.getBrowser() + "\n");
            Statistics statistics = new Statistics();
            statistics.addEntry(logEntry);
            System.out.println("Общий объём трафика: " + statistics.getTrafficRate());
        }
    }
}

