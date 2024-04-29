package oopintro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("c:\\PATH\\access.log");
        System.out.println(readFile(file));
    }

    public static String readFile(File file) {
        String result = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int totalLines = 0;
            while ((line = reader.readLine()) != null) {
                totalLines++;
                int length = line.length();
                //  result = line + "\t" + length;
                System.out.println(line + "\t" + length);
            }

           /* List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                totalLines++;
                lines.add(line);
                int length = line.length();
                //result = lines.toString();
                result = lines + "\t" + length;
                //System.out.println(line + "\t" + length);*/

            // reader.close();
            System.out.printf("Общее количество строк в файле: %d\n", totalLines);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static List<String> readFromFile(File file) throws FileNotFoundException {
        List<String> readFromFile = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                readFromFile.add(scanner.nextLine());
            }
        }
        return readFromFile;
    }
}






