package compare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgentAnalyzer {
    private static final Pattern USER_AGENT_PATTERN = Pattern.compile(".*?(\\(.*?\\))");

    public static void main(String[] args) throws IOException {
        try {
            File file = new File("c:\\PATH\\access.log");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int totalLines = 0;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                totalLines++;
                lines.add(line);
            }
            reader.close();
            System.out.printf("Общее количество строк в файле: %d\n", totalLines);
            List<String> userAgents = readUserAgentsFromFile(file);
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
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static List<String> readUserAgentsFromFile(File file) throws FileNotFoundException {
        List<String> userAgents = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                userAgents.add(scanner.nextLine());
            }
        }
        return userAgents;
    }
}