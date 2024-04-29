package oopintro;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static oopintro.DateFormat.formatDate;
import static oopintro.ReadFile.readFromFile;

public class LogEntry2 {

    private final String ipAddress;
    private final LocalDateTime dateTime;
    private final HttpMethod method;
    private final String requestPath;
    private final int responseCode;
    private final long dataSize;
    private final String referer;
    private final String userAgent;

    public LogEntry2(String file) throws FileNotFoundException {
        String text = readFromFile(new File(String.valueOf(new File(file)))).toString();
        String[] parts = text.split("\\s+");
        this.ipAddress = parts[0];
        this.dateTime = LocalDateTime.parse(formatDate(parts[3] + " " + parts[4]));
        this.method = HttpMethod.valueOf("GET");
        this.requestPath = parts[6].toUpperCase() + " " + parts[7].substring(0, 8);
        this.responseCode = Integer.parseInt(parts[8]);
        this.dataSize = Long.parseLong(parts[9]);
        this.referer = parts[10].toUpperCase();
        this.userAgent = parts[11] + " " + parts[12] + " " + parts[13] + " " + parts[14] + " " + parts[15] + " " + parts[16] + " " + parts[17] + " " + parts[18] + " " + parts[19] + " " + parts[20] + " " + parts[21] + " " + parts[22] + " " + parts[23] + " " + parts[24];
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

  /*  public HttpMethod getMethod() {
        return method;
    }
*/
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

