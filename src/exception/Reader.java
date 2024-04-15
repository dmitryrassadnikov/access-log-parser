package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("c:\\PATH\\access.log");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                System.out.println(length);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}