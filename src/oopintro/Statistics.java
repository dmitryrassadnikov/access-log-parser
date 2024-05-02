package oopintro;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

import static oopintro.UserAgent.isBot;

public class Statistics {

    private final Set<String> referringDomains = new HashSet<>();
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
    private Map<Integer, Integer> peakVisitsPerSecond = new HashMap<>();
    private Set<String> domains = new HashSet<>();

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

    public void recordVisit(long timestamp) {
        int second = (int) (timestamp / 1000);
        if (!peakVisitsPerSecond.containsKey(second)) {
            peakVisitsPerSecond.put(second, 0);
        }
        peakVisitsPerSecond.put(second, peakVisitsPerSecond.get(second) + 1);
    }

    public int getPeakVisitsPerSecond() {
        int maxVisits = 0;
        for (Map.Entry<Integer, Integer> entry : peakVisitsPerSecond.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
            }
        }
        return maxVisits;
    }

    public Set<String> getReferringDomains() {
        return referringDomains;
    }

    public void addReferer(String referer) throws IOException {
        String domain = extractDomainFromUrl(referer).toString();
        referringDomains.add(domain);
    }

    public Set<String> extractDomainFromUrl(String url) throws IOException {
        Set<String> domains = new HashSet<>();
        if (url.contains("-")) {
            return Collections.singleton(" ");
        } else if (url.contains("https%3A%2F%2Fwww.rbc.ru&pathname=%2Fpolitics%2F27%2F10%2F2022%2F635a17849a7947739cc38755%3Ffrom%3Dfrom_main_1&project=rbc")) {
            return Collections.singleton("www.rbc.ru");
        }
        URL obj = new URL(url);
        String host = obj.getHost();
        domains.add(host);
        return domains;
    }

    public int getMaxVisitsByUser() {
        int maxVisits = 0;
        for (Map.Entry<Integer, Integer> entry : peakVisitsPerSecond.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
            }
        }
        return maxVisits;
    }
}


