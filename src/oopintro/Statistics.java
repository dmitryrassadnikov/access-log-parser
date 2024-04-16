package oopintro;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Statistics {

    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;

    public Statistics() {

    }

    public void addEntry(LogEntry entry) {

        totalTraffic += entry.getDataSize();

        /*if (entry.getDateTime().isBefore(minTime) || minTime == null) {
            minTime = entry.getDateTime();
        }
        if (entry.getDateTime().isAfter(maxTime) || maxTime == null) {
            maxTime = entry.getDateTime().plusHours(1);
        }*/
        minTime = entry.getDateTime();
        maxTime = entry.getDateTime().plusHours(1);

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
