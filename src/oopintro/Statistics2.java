package oopintro;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Statistics2 {

    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/96.0.4664.110 Safari/537.36";
    UserAgent agent = new UserAgent(userAgent);
    String path = "c:\\PATH\\access.log";
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private Map<String, Integer> operatingSystems;
    private Set<String> pages;

    public Statistics2() {
        totalTraffic = 0;
        minTime = LocalDateTime.MAX;
        maxTime = LocalDateTime.MIN;
        operatingSystems = new HashMap<>();
        pages = new HashSet<>();
    }

    public void addEntry(LogEntry2 entry) {
        totalTraffic += entry.getDataSize();
        if (entry.getDateTime().isBefore(minTime)) {
            minTime = entry.getDateTime();
            System.out.println("Дата минимальная:" + minTime);
        }
        if (entry.getDateTime().isAfter(maxTime)) {
            maxTime = entry.getDateTime().plusHours(1);
            System.out.println("Дата максимальная:" + maxTime);
        }
        if (agent.getOperatingSystem() != null && agent.getBrowser() != null) {
            Integer count = operatingSystems.get(agent.getOperatingSystem() + "/" + agent.getBrowser());
            if (count == null) {
                count = 0;
            }
            operatingSystems.put(agent.getOperatingSystem() + "/" + agent.getBrowser(), count + 1);
        }
        if (entry.getResponseCode() == 200) {
            pages.add(path);
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


    public Map<String, Double> getOperatingSystemsStatistics() {
        int total = operatingSystems.values().stream().mapToInt(Integer::intValue).sum();
       // System.out.println("ТЕСТ" + total);
        Map<String, Double> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : operatingSystems.entrySet()) {
            result.put(entry.getKey(), (double) entry.getValue() / total);
        }
        return result;
    }

    public Set<String> getPages() {
        return pages;
    }

}
