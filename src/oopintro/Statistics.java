package oopintro;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Statistics {

    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;


    public Statistics() {
        totalTraffic = 0;
        minTime = LocalDateTime.MAX;
        maxTime = LocalDateTime.MIN;
    }

    public void addEntry(LogEntry entry) {
        totalTraffic += (int) entry.getContentLength();
        if (entry.getDateTime().isBefore(minTime)) {
            minTime = entry.getDateTime();
            System.out.println("Дата минимальная:" + minTime);
        }
        if (entry.getDateTime().isAfter(maxTime)) {
            maxTime = entry.getDateTime().plusHours(1);
            System.out.println("Дата максимальная:" + maxTime);
        }
    }

    public double getTrafficRate() {
        long hours = ChronoUnit.HOURS.between(minTime, maxTime);
        if (hours != 0) {
            return totalTraffic / hours;
        } else {
            return 0;
        }
    }
}