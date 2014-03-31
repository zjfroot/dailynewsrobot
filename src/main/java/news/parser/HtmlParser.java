package news.parser;

import news.model.News;
import news.model.NewsSummary;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public interface HtmlParser {
    List<NewsSummary> getNewsSummaryList() throws IOException;

    News getNewsDetail(NewsSummary summary) throws IOException;
}
