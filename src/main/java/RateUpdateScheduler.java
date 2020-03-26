import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class RateUpdateScheduler {

    private final static String URL = "https://www.portfolio.hu";

    public Map<RateType, Double> getCurrentRates() {
        Map<RateType, Double> result = new HashMap<>();
        try {
            Document response = executeRequest();

            for (RateType rateType : RateType.values()) {
                Element rateElement = response.select(rateType.getSelector()).first();
                TextNode rateText = (TextNode) rateElement.childNode(0);

                String rateTextString = rateText.getWholeText().replace(" ", "");
                result.put(rateType, Double.valueOf(rateTextString));
            }

            System.out.println("Request received - update success");
        } catch (Exception e) {
            System.out.println("Error during fetching rates : " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    private Document executeRequest() throws IOException {
        System.out.println("Request sent");

        Connection connectionTest = Jsoup.connect(URL)
                .method(Connection.Method.GET);
        return Jsoup.parse(new String(
                connectionTest.execute().bodyAsBytes(), "ISO-8859-5"));
    }


}
