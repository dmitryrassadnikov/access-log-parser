package oopintro;

import java.io.File;
import java.io.IOException;

import static oopintro.ReadFile.readFile;
import static oopintro.ReadFile.readFromFile;

public class Split2 {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\PATH\\access.log");
        String text = readFromFile(new File(String.valueOf(file))).toString();
        //System.out.println(text);
        //String input = "173.157.212.202 - - [26/Sep/2022:10:18:33 +0300] \"GET /information/november-reports/anthropology/6378/63/870933 HTTP/1.0\" 200 8145 \"https://www.nova-news.ru//pr/6365/68/842022\" \"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:105.0) Gecko/20100101 Firefox/105.0\"";
        String[] parts = text.split(" ");
        for (String part : parts) {
            System.out.println(part);
        }
        System.out.println("Элемент массива: " + parts[1]);
    }
}
