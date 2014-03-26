package news.service;

import news.api.HtmlParser;
import news.api.NewsService;
import news.model.News;
import news.model.NewsSummary;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class RealNewsService implements NewsService {
    @Override
    public List<News> fetchLatestNews(HtmlParser htmlParser) {
        List<News> news = new ArrayList<>();

        for(NewsSummary summary : htmlParser.getNewsSummaryList()){
            news.add(htmlParser.getNewsDetail(summary));
        }

        return news;
    }
}
