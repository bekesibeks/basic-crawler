import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.net.URL;

public class RateUpdateScheduler {

    private final static String URL = "https://www.portfolio.hu";
    private final static String OTP_SELECTOR = "ul > li:nth-child(4) > a > span.price";
    private final static String MOL_SELECTOR = "ul > li:nth-child(5) > a > span.price";
    private final static String TELEKOM_SELECTOR = "ul > li:nth-child(7) > a > span.price";
    private final static String FOURIG_SELECTOR = "ul > li:nth-child(9) > a > span.price";

    public String getCurrentRates() {
        try {
            System.out.println("Request sent");

            Connection connectionTest = Jsoup.connect(URL)
                    .method(Connection.Method.GET);
            Document response = Jsoup.parse(new String(
                    connectionTest.execute().bodyAsBytes(), "ISO-8859-5"));
            Element otpRateElement = response.select(OTP_SELECTOR).first();
            TextNode node = (TextNode) otpRateElement.childNode(0);

            System.out.println("Request received " + node.getWholeText());
        } catch (IOException e) {
            System.out.println("Error during fetching rates : " + e.getMessage());
            e.printStackTrace();
        }

        return "";
    }


}
