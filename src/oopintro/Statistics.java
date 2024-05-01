package oopintro;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private String date;
    private Map<String, Integer> operatingSystems;
    private Set<String> pages;
    private HashSet<String> nonExistingPages = new HashSet<>();
    private HashMap<String, Integer> browserStats = new HashMap<>();

    public Statistics() {
        operatingSystems = new HashMap<>();
        pages = new HashSet<>();
    }

    public void addEntry(LogEntry logEntry) {
        totalTraffic += (double) logEntry.getContentLength();
        if (UserAgent.getOperatingSystem() != null && UserAgent.getBrowser() != null) {
            Integer count = operatingSystems.get(UserAgent.getOperatingSystem() + "/" + UserAgent.getBrowser());
            if (count == null) {
                count = 0;
            }
            operatingSystems.put(UserAgent.getOperatingSystem() + "/" + UserAgent.getBrowser(), count + 1);
        }
        if (logEntry.getResponseCode() == 200) {
            pages.add(logEntry.getPath());
        }
        if (logEntry.getResponseCode() == 404) {
            nonExistingPages.add(logEntry.getPath());
        }
        if (!browserStats.containsKey(UserAgent.getBrowser())) {
            browserStats.put(UserAgent.getBrowser(), 1);
        } else {
            browserStats.put(UserAgent.getBrowser(), browserStats.get(UserAgent.getBrowser()) + 1);
        }
    }

    public double getTrafficRate() {
        System.out.println("Общий трафик в байтах: " + totalTraffic);
        return totalTraffic;
    }

    public Map<String, Double> getOperatingSystemsStatistics() {
        int total = operatingSystems.values().stream().mapToInt(Integer::intValue).sum();
        Map<String, Double> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : operatingSystems.entrySet()) {
            result.put(entry.getKey(), (double) entry.getValue() / total);
        }
        return result;
    }

    public Set<String> getPages() {
        return pages;
    }

    public Map<String, Double> getBrowserStatistics() {
        int totalBrowsers = browserStats.size();
        Map<String, Double> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : browserStats.entrySet()) {
            String browser = entry.getKey();
            int count = entry.getValue();
            result.put(browser, (double) count / totalBrowsers);
        }
        return result;
    }

    public HashSet<String> getNonExistingPages() {
        return nonExistingPages;
    }
}