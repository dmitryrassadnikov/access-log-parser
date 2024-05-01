package oopintro;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Locale.filter;
import static oopintro.UserAgent.isBot;

public class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private String date;
    private Map<String, Integer> operatingSystems;
    private Set<String> pages;
    private HashSet<String> nonExistingPages = new HashSet<>();
    private HashMap<String, Integer> browserStats = new HashMap<>();
    private HashMap<String, Integer> errorStats = new HashMap<>();
    private HashMap<String, Integer> uniqueIPs = new HashMap<>();

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
       if (!isBot(logEntry.getUserAgent())) {

            if (logEntry.getResponseCode() == 404) {
                nonExistingPages.add(logEntry.getPath());
            }
            if (logEntry.getResponseCode() >= 400 && logEntry.getResponseCode() <= 599) {
                errorStats.put(logEntry.getPath(), errorStats.getOrDefault(logEntry.getPath(), 0) + 1);
            }
            if (!browserStats.containsKey(UserAgent.getBrowser())) {
                browserStats.put(UserAgent.getBrowser(), 1);
            } else {
                browserStats.put(UserAgent.getBrowser(), browserStats.get(UserAgent.getBrowser()) + 1);
            }
            if (!uniqueIPs.containsKey(logEntry.getIpAddress())) {
                uniqueIPs.put(logEntry.getIpAddress(), 1);
            } else {
                uniqueIPs.put(logEntry.getIpAddress(), uniqueIPs.get(logEntry.getIpAddress()) + 1);
            }
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

    public double getAverageVisitsPerHour() {
        long visits = browserStats.values().stream().reduce(Math.toIntExact(0L), (a, b) -> a + b);
        return (double) visits;
    }

    public double getAverageErrorRatePerHour() {
        long errors = errorStats.values().stream().reduce(Math.toIntExact(0L), (a, b) -> a + b);
        return (double) errors;
    }

    public double getAverageVisitsPerUser() {
        long totalVisits = browserStats.values().stream().reduce(Math.toIntExact(0L), (a, b) -> a + b);
        long uniqueUsers = uniqueIPs.values().stream().reduce(Math.toIntExact(0L), (a, b) -> a + b);
        return (double) totalVisits / uniqueUsers;
    }
}