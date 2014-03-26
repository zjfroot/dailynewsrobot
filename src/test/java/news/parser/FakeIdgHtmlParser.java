package news.parser;

import news.api.HtmlParser;
import news.model.News;
import news.model.NewsSummary;

import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class FakeIdgHtmlParser implements HtmlParser {
    @Override
    public List<NewsSummary> getNewsSummaryList() {
        return null;
    }

    @Override
    public News getNewsDetail(NewsSummary newsSummary) {
        return null;
    }
}
