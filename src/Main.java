import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            int i = 0;
            while (true) {
                System.out.println("Укажите путь к файлу:");
                String path = new Scanner(System.in).nextLine();
                File file = new File(path);
                boolean fileExists = file.exists();
                boolean isDirectory = file.isDirectory();
                String exit = "выход";
                if (path.compareTo(exit) == 0) {
                    break;
                } else if ((fileExists == false) || (isDirectory == true)) {
                    System.out.println("Файл не существует или указанный путь является путём к папке, а не к файлу!");
                    continue;
                } else {
                    System.out.println("Путь указан верно!");
                    i++;
                }
                System.out.println("Это файл номер: " + i);
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                int totalLines = 0;
                int maxLength = 0;
                int minLength = Integer.MAX_VALUE;
                List<String> lines = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    totalLines++;
                    if (line.length() > maxLength) {
                        maxLength = line.length();
                    }
                    if (line.length() < minLength) {
                        minLength = line.length();
                    }
                    lines.add(line);
                }
                reader.close();
                System.out.printf("Общее количество строк в файле: %d\n", totalLines);
                System.out.printf("Длина самой длинной строки в файле: %d\n", maxLength);
                System.out.printf("Длина самой короткой строки в файле: %d\n", minLength);
                for (String s : lines) {
                    if (s.length() > 1024) {
                        throw new CustException("Строка слишком длинная!");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class CustException extends RuntimeException {
    public CustException(String message) {
        super(message);
    }
}