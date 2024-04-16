package oopintro;

import java.time.LocalDateTime;

public class LogEntry {

    private final String ipAddress;
    private final LocalDateTime dateTime;
    private final HttpMethod method;
    private final String requestPath;
    private final int responseCode;
    private final long dataSize;
    private final String referer;
    private final String userAgent;

    public LogEntry(String logLine) {
        String[] parts = logLine.split(" ");
        this.ipAddress = parts[0];
        this.dateTime = LocalDateTime.parse(parts[1]);
        this.method = HttpMethod.valueOf(parts[2].toUpperCase());
        this.requestPath = parts[3];
        this.responseCode = Integer.parseInt(parts[4]);
        this.dataSize = Long.parseLong(parts[5]);
        this.referer = parts[6];
        this.userAgent = parts[7];
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public long getDataSize() {
        return dataSize;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public enum HttpMethod {
        GET, POST, PUT, DELETE, PATCH, TRACE, LINK, UNLINK
    }
}

