package compare;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oopintro.ReadFromFile.readFromFile;

public class UserAgentAnalyzer {
    private static final Pattern USER_AGENT_PATTERN = Pattern.compile(".*?(\\(.*?\\))");

    public static void main(String[] args) throws IOException {
        File file = new File("c:\\PATH\\access.log");
        List<String> userAgents = readFromFile(file);
        int googlebotCount = 0;
        int yandexbotCount = 0;
        for (String userAgent : userAgents) {
            Matcher matcher = USER_AGENT_PATTERN.matcher(userAgent);
            if (matcher.find()) {
                String userAgentFragment = matcher.group(1);
                String[] parts = userAgentFragment.split(";");
                if (parts.length >= 2) {
                    String botName = parts[1].trim();
                    if (botName.equals("Googlebot/2.1")) {
                        googlebotCount++;
                    } else if (botName.equals("YandexBot/3.0")) {
                        yandexbotCount++;
                    }
                }
            }
        }
        System.out.printf("Доля запросов от YandexBot: %.2f%%\n", (float) yandexbotCount / userAgents.size() * 100);
        System.out.printf("Доля запросов от Googlebot: %.2f%%\n", (float) googlebotCount / userAgents.size() * 100);
    }
}