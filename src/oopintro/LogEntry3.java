package oopintro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogEntry3 {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\PATH\\access3.log");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Pattern pattern = Pattern.compile("\\s*(\\S+)\\s*");
            while (reader.ready()) {
                String line = reader.readLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(matcher.group(1));
                }
            }
        }
    }
}