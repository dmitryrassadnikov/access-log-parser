package oopintro;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oopintro.DateFormat.formatDate;

public class LogEntry4 {

    private final String ipAddress;
    private final LocalDateTime dateTime;
    private final String method;
    private final String path;
    private final int responseCode;
    private final long contentLength;
    private final String referer;
    private final String userAgent;


    public LogEntry4(String file) {
        //Pattern pattern = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) - - (\\[[\\w:/]+)\\s+(\\S+) (\\S+) (\\S+) (\\S+) (\\d{3}) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+)");
        //Pattern pattern = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) - - (\\[[\\w:/]+\\s+\\S+) (\\S+) (\\S+\\s+\\S+) (\\d{3}) (\\d{1,5}) (\\S+) (\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\S+\\s+\\S+\\s+\\S+)");
        Pattern pattern = Pattern.compile("\\s*(\\S+)\\s*");
        //  Pattern pattern = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) - - (\\[[\\w:/]+)");
        Matcher matcher = pattern.matcher((CharSequence) file);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid log line format.");
        }
        this.ipAddress = matcher.group(1);
        this.dateTime = LocalDateTime.parse(formatDate(matcher.group(2)));
        //this.method = matcher.group(3).substring(1);
        this.method = String.valueOf(Method.valueOf("GET"));
        this.path = matcher.group(4);
        this.responseCode = Integer.parseInt(matcher.group(5));
        this.contentLength = Long.parseLong(matcher.group(6));
        this.referer = matcher.group(7);
        this.userAgent = matcher.group(8);
        System.out.println("GROUP: " + matcher.group(1));
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
        return "LogEntry{" +
                "ipAddress='" + ipAddress + '\'' +
                ", dateTime=" + dateTime +
                ", method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", responseCode=" + responseCode +
                ", contentLength=" + contentLength +
                ", referer='" + referer + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }

    public enum Method {
        GET, POST, PUT, DELETE
    }
    public static List<String> readFromFile(File file) throws FileNotFoundException {
        List<String> readFromFile = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                readFromFile.add(scanner.nextLine());
            }
        }
        return readFromFile;
    }
}