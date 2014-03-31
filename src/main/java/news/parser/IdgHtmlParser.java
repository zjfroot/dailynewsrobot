package news.parser;

import com.google.inject.Inject;
import news.wrapper.JsoupWrapper;
import news.model.News;
import news.model.NewsSummary;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class IdgHtmlParser implements HtmlParser {

    private JsoupWrapper wrapper;

    @Inject
    public IdgHtmlParser(JsoupWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public List<NewsSummary> getNewsSummaryList() throws IOException {
        List<NewsSummary> newsSummaryList = new ArrayList<>();

        Document doc = wrapper.get("http://www.idg.se/2.1121");
        for (Element e : doc.getElementsByClass("newarticle")) {
            Element newsElement = e.getElementsByTag("a").get(1);
            String newsTitle = newsElement.text();
            String newsUrl = "http://www.idg.se" + newsElement.attr("href");
            newsSummaryList.add(new NewsSummary(newsTitle, newsUrl));
        }

        return newsSummaryList;
    }

    @Override
    public News getNewsDetail(NewsSummary summary) throws IOException {
        Document doc = wrapper.get(summary.getUrl());
        News news = new News(summary.getTitle(), doc.select("div.articleBody").toString());
        return news;
    }
}
