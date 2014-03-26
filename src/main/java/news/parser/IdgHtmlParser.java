package news.parser;

import news.api.HtmlParser;
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

    @Override
    public List<NewsSummary> getNewsSummaryList() {
        List<NewsSummary> newsSummaryList = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("http://www.idg.se/2.1121").get();
            for (Element e : doc.getElementsByClass("newarticle")) {
                Element newsElement = e.getElementsByTag("a").get(0);
                String newsTitle = newsElement.text();
                String newsUrl = "http://www.idg.se" + newsElement.attr("href");
                newsSummaryList.add(new NewsSummary(newsTitle,newsUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newsSummaryList;
    }

    @Override
    public News getNewsDetail(NewsSummary newsSummary) {
        try {
            Document doc = Jsoup.connect(newsSummary.getUrl()).get();
            String html = doc.select("div.articleBody").toString();
            return new News(newsSummary.getTitle(),html);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}