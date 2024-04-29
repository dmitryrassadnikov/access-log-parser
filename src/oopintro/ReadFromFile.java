package oopintro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

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






