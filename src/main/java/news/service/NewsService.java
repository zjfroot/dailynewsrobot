package news.service;

import news.parser.HtmlParser;
import news.model.News;

import java.io.IOException;
import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public interface NewsService {
    List<News> fetchLatestNews() throws IOException;
}
