package oopintro;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import static oopintro.MinMaxDate.minDate;

public class Statistics2 {
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    /* private final LocalDateTime minTime;
     private final LocalDateTime maxTime;*/
    private int totalTraffic;


    public Statistics2() {
        this.totalTraffic = 0;
        this.minTime = LocalDateTime.MIN;
        this.maxTime = LocalDateTime.MAX;
        // System.out.println(minTime);
        // System.out.println(maxTime);
    }

    public void addEntry(LogEntry logEntry) {
        totalTraffic += (int) logEntry.getContentLength();
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(logEntry.getDateTime());
        System.out.println("Дата минимальная 1:" + minTime);
        System.out.println("Даты: " + dates);
    }

    public double getTrafficRate() {
        // System.out.println("Даты: " + dates);
        // System.out.println("Дата минимальная 2:" + minTime);
        // System.out.println("Дата максимальная 2:" + maxTime);
        Duration duration = Duration.between(minTime, maxTime);
        long hours = duration.toHours();
        System.out.println("Период времени в часах = " + hours);
        // System.out.println("Общий трафик = " + totalTraffic);
        if (hours != 0) {
            return (double) totalTraffic / hours;
        } else {
            return 0;
        }
    }
}


