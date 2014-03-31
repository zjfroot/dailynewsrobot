package news.parser;

import news.model.News;
import news.model.NewsSummary;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class SvdHtmlParser implements HtmlParser {
    @Override
    public List<NewsSummary> getNewsSummaryList() {
        return null;
    }

    @Override
    public News getNewsDetail(NewsSummary summary) throws IOException {
        return null;
    }
}
