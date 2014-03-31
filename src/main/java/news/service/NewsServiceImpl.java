package news.service;

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
    @Override
    public List<News> fetchLatestNews(HtmlParser htmlParser) throws IOException {
        List<News> news = new ArrayList<>();

        for(NewsSummary summary : htmlParser.getNewsSummaryList()){
            news.add(htmlParser.getNewsDetail(summary));
        }

        return news;
    }
}
