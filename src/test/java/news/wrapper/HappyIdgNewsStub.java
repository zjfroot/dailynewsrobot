package news.wrapper;

import news.api.JsoupWrapper;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jifeng Zhang on 3/31/14.
 */
public class HappyIdgNewsStub implements JsoupWrapper {

    @Override
    public Document get(String url) {
        InputStream is = this.getClass().getResourceAsStream("/IdgNewsHappyHtml.html");
        try {
            return Jsoup.parse(IOUtils.toString(is, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
