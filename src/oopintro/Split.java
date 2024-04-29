package oopintro;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oopintro.ReadFile.readFile;

public class Split {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\PATH\\access.log");
        String text = readFile(file);
        //String text = "John Doe 47 Hillsboro Road 32000";
        Pattern p = Pattern.compile("\\s");
        String[] fields = p.split(text.toString());
        for (int i = 0; i < fields.length; i++)
            System.out.println(fields[i]);
        }
    }
