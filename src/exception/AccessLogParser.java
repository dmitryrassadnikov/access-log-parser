package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccessLogParser {

    public static void main(String[] args) {
        try {
            // Проверка существования файла и что это файл, а не папка
            FileReader fileReader = new FileReader("c:\\PATH\\access.log");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                System.out.println(length);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}