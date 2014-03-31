package news.wrapper;

import news.exceptions.FailedToPerformJsoupGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public class RealJsoupWrapper implements JsoupWrapper {
    @Override
    public Document get(String url) throws IOException {

        return Jsoup.connect(url).get();

    }
}
