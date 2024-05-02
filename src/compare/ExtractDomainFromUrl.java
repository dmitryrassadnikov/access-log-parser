package compare;

import java.net.URL;

public class ExtractDomainFromUrl {

    public static void main(String[] args) throws Exception {
        String url = "https://www.nova-news.ru//august-report/november-reports/?n=3";
        System.out.println(extractDomainFromUrl("-"));
    }

    public static String extractDomainFromUrl(String url) throws Exception {
        String domain = "";
        if (domain.contains("-")) {
            System.out.println("МИНУС");
        } else {
            URL url1 = new URL(url);
            domain = url1.getHost();
            //System.out.println(url1.getHost()); // Выведет example.com
        }
        return domain;
    }
}


