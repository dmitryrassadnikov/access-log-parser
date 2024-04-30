package oopintro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgent {

    private static String operatingSystem;
    private static String browser;

    public UserAgent(String userAgent) {
        Pattern pattern = Pattern.compile("(?i)(?:windows|macos|linux)");
        Matcher matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            this.operatingSystem = matcher.group();
        } else {
            this.operatingSystem = "unknown";
        }

        pattern = Pattern.compile("(?i)(?:edge|firefox|chrome|opera|other)");
        matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            this.browser = matcher.group();
        } else {
            this.browser = "other";
        }
    }

    public static String getOperatingSystem() {
        return operatingSystem;
    }

    public static String getBrowser() {
        return browser;
    }
}