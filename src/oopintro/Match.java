package oopintro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {
    public static void main(String[] args) {
        String text = "Это \"пример № 1\" текста с \"кавычками\"";
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}