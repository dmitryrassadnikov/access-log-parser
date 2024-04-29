package oopintro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccessLogReader {
    public static void main(String[] args) {
        try {
            // Проверка существования файла и того, что указанный путь является путём именно к файлу, а не к папке
            FileReader fileReader = new FileReader("c:\\PATH\\access3.log");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
               // int length = line.length();
               // System.out.println(line + "\t" + length);
              LogEntry4 logEntry = new LogEntry4(line);
               //reader.close();
               System.out.println(logEntry);
            }
           //System.out.println(logEntry);
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}





