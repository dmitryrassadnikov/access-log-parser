package oopintro;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oopintro.DateFormat.formatDate;

public class LogEntry {

    private String ipAddress;
    private LocalDateTime dateTime;
    private String method;
    private String path;
    private int responseCode;
    private long contentLength;
    private String referer;
    private String userAgent;


    public LogEntry(String file) {
        Pattern pattern = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) - - (\\[[^\\]]+\\]) \"(GET|POST|HEAD) (.+?)\" (\\d{3}) (\\d+) \"(.+)\" \"(.+)\"");
        Matcher matcher = pattern.matcher(file);
        if (matcher.find()) {
            this.ipAddress = matcher.group(1);
            this.dateTime = LocalDateTime.parse(formatDate(matcher.group(2)));
            this.method = String.valueOf(HttpMethod.valueOf("GET"));
            this.path = matcher.group(4);
            this.responseCode = Integer.parseInt(matcher.group(5));
            this.contentLength = Long.parseLong(matcher.group(6));
            this.referer = matcher.group(7);
            this.userAgent = matcher.group(8);
        }
    }



    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public long getContentLength() {
        return contentLength;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        return String.format("LogEntry{IP-адрес='%s', Дата и время=%s, Метод='%s', Путь='%s', Код ответа=%d, Длина содержимого=%d, Реферер='%s', User-Agent='%s'}",
                ipAddress, dateTime, method, path, responseCode, contentLength, referer, userAgent);

    }

    public enum HttpMethod {
        GET, POST, PUT, DELETE, PATCH
    }

}


