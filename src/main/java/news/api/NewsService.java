package news.api;

import news.model.News;

import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public interface NewsService {

    List<News> fetchLatestNews(HtmlParser hs);
}
