package news.service;

import com.google.inject.Inject;
import news.parser.HtmlParser;
import news.model.News;
import news.model.NewsSummary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class NewsServiceImpl implements NewsService {
    HtmlParser parser;

    @Inject
    public NewsServiceImpl(HtmlParser parser) {
        this.parser = parser;
    }

    @Override
    public List<News> fetchLatestNews() throws IOException {
        List<News> news = new ArrayList<>();
        for(NewsSummary summary : parser.getNewsSummaryList()){
            news.add(parser.getNewsDetail(summary));
        }
        return news;
    }
}
