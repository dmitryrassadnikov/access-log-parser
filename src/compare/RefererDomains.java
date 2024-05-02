package compare;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class RefererDomains {
    public static Set<String> getRefererDomains(String url) throws IOException {
        Set<String> domains = new HashSet<>();
        URL obj = new URL(url);
        String host = obj.getHost();
        domains.add(host);
        return domains;
    }

    public static void main(String[] args) throws IOException {
        String url = "https://example.com/";
        Set<String> domains = getRefererDomains(url);
        System.out.println(domains);
    }
}
