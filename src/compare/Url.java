package compare;

import java.net.URL;

public class Url {

        public static void main(String [] args) throws Exception {
            URL url = new URL("https://example.com/page4.html");
            System.out.println(url.getHost()); // Выведет example.com
        }
    }
