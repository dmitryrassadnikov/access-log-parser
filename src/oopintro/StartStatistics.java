package oopintro;

public class StartStatistics {
    public static void main(String[] args) {
        String logLine = "211.71.205.41 2024-04-16T03:10:00 GET /index.html 200 8976 https://example.com Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/96.0.4664.110 Safari/537.36";
        LogEntry entry = new LogEntry(logLine);

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/96.0.4664.110 Safari/537.36";
        UserAgent agent = new UserAgent(userAgent);

        Statistics statistics = new Statistics();
        statistics.addEntry(entry);

        System.out.println("IP-адрес: " + entry.getIpAddress());
        System.out.println("Дата и время: " + entry.getDateTime());
        System.out.println("Метод запроса: " + entry.getMethod());
        System.out.println("Путь запроса: " + entry.getRequestPath());
        System.out.println("Код ответа: " + entry.getResponseCode());
        System.out.println("Размер данных: " + entry.getDataSize());
        System.out.println("Реферер: " + entry.getReferer());
        System.out.println("User-Agent: " + entry.getUserAgent());

        System.out.println("Операционная система: " + agent.getOperatingSystem());
        System.out.println("Браузер: " + agent.getBrowser());

        System.out.println("Общий объём трафика: " + statistics.getTrafficRate());
    }
}