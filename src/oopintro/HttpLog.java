package oopintro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpLog {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\PATH\\access3.log");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Pattern pattern = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) - - (\\[[^\\]]+\\]) \"(GET|POST|HEAD) (.+?)\" (\\d{3}) (\\d+) \"(.+)\" \"(.+)\"");
            while (reader.ready()) {
                String line = reader.readLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.printf("%s %s %s %s %s %s %s %s\n",
                            matcher.group(1),
                            matcher.group(2),
                            matcher.group(3),
                            matcher.group(4),
                            matcher.group(5),
                            matcher.group(6),
                            matcher.group(7),
                            matcher.group(8));
                }
            }
        }
    }
}