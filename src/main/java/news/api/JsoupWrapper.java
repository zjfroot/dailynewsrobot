package news.api;

import org.jsoup.nodes.Document;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public interface JsoupWrapper {
    public Document getNewsSummary(String url);
}
