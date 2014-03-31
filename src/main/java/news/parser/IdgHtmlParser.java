package news.parser;

import news.api.HtmlParser;
import news.api.JsoupWrapper;
import news.model.News;
import news.model.NewsSummary;
import org.jsoup.Jsoup;
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

    public IdgHtmlParser(JsoupWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public List<NewsSummary> getNewsSummaryList() {
        List<NewsSummary> newsSummaryList = new ArrayList<>();

        Document doc = wrapper.get("http://www.idg.se/2.1121");
        for (Element e : doc.getElementsByClass("newarticle")) {
            Element newsElement = e.getElementsByTag("a").get(0);
            String newsTitle = newsElement.text();
            String newsUrl = "http://www.idg.se" + newsElement.attr("href");
            newsSummaryList.add(new NewsSummary(newsTitle, newsUrl));
        }


        return newsSummaryList;
    }

    @Override
    public News getNewsDetail(String newUrl, String title) {
        Document doc = wrapper.get(newUrl);
        News news = new News(title, doc.select("div.articleBody").toString());
        return news;
    }
}
