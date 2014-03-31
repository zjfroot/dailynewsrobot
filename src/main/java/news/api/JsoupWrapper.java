package news.api;

import news.model.News;
import news.model.NewsSummary;
import org.jsoup.nodes.Document;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public interface JsoupWrapper {
    public Document get(String url);
}
