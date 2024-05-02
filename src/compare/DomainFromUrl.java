package compare;

public class DomainFromUrl {

    public static void main(String[] args) {

        Statistics statistics = new Statistics();
        // Имитация добавления рефереров
      /*  statistics.addReferer("https://example.com/page1.html");
        statistics.addReferer("https://example.com/page2.html");
        statistics.addReferer("https://example.net/page3.html");
        statistics.addReferer("https://example.org/page4.html");
*/
        System.out.println("Рефереры: " + statistics.getReferringDomains());
    }

    public static String extractDomainFromUrl(String url) {
        String domain = "";
        int index = url.indexOf("://");
        if (index != -1) {
            index = url.indexOf('/', index + 3);
            if (index != -1) {
                domain = url.substring(index);
            }
        }
        return domain;
    }

}



