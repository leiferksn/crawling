package bg.mine.backend;

import bg.mine.backend.model.Product;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leif on 07/03/15.
 */

public class Parser {

    private URL topURL;
    private List<Product> productLIst = new ArrayList<Product>();
    private Document doc;

    public Parser(String url, Map<String, String> prms) throws MalformedURLException, IOException {
        topURL = new URL(url);
        Connection c  = Jsoup.connect(topURL.toString());
        c.data(prms);
        doc = c.get();
    }

    public void parse(){
        // TODO: get all the information and put it in product objects
        Elements lmnts =  doc.select("li[id^=result]");
        // System.out.println(lmnts.toString());
    }

    public List<Product> getProductLIst() {
        return productLIst;
    }

    public void setProductLIst(List<Product> productLIst) {
        this.productLIst = productLIst;
    }

    public URL getTopURL() {
        return topURL;
    }

    public void setTopURL(URL topURL) {
        this.topURL = topURL;
    }
}
