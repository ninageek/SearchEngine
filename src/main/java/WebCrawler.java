import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class WebCrawler {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawler.class);
    String getPageText(String pageAddress) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(pageAddress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());

        }
        return result.toString();
    }
}
