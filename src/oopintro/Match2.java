package oopintro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match2 {
    public static void main(String[] args) {
        String text = "Это пример текста с пробелами";
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}