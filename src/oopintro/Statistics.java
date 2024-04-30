package oopintro;

import java.time.LocalDateTime;


public class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private String date;

    public Statistics() {
    }

    public void addEntry(LogEntry logEntry) {
                 totalTraffic += (double) logEntry.getContentLength();
             }

    public double getTrafficRate() {
        System.out.println("Общий трафик в байтах: " + totalTraffic);
        return totalTraffic;
    }
}



