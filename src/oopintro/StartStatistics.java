package oopintro;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static oopintro.ReadFile.readFile;
import static oopintro.ReadFile.readFromFile;

public class StartStatistics {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("c:\\PATH\\access3.log");
       // List<String> log = readFromFile(file);

        //String logLine = readFile(file);
       // String file = readFromFile(String.valueOf(logLine)).toString();
        //System.out.println(logLine);
       // System.out.println(logLine);
        String logLine = "209.209.95.6 - - [26/Sep/2022:09:12:09 +0300] \"GET /pandemic/biology/?region=256&minor=no&y=2021&crime=571&motif=no&legality_sentence=576&decision=583&punish=584&punish_a=612&xfield=crime&yfield=y&nr=onviction&show=1 HTTP/1.0\" 200 9182 \"https://www.nova-news.ru//foreign/biology/?region=256&minor=no&y=2021&m=2&crime=571&motif=no&legality_sentence=576&decision=583&punish=584&punish_a=612&xfield=crime&yfield=y&nr=onviction&show=1\" \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.114 YaBrowser/208.194.152.275 Yowser/2.5 Safari/537.36";
      //  LogEntry logEntry = new LogEntry(log.toString());
        System.out.println(logLine);
    }
}

