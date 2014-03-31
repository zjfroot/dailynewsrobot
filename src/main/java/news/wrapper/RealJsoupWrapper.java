package news.wrapper;

import news.api.JsoupWrapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public class RealJsoupWrapper implements JsoupWrapper {
    @Override
    public Document get(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
