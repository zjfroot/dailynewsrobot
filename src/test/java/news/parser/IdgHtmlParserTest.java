package news.parser;

import news.model.News;
import news.model.NewsSummary;
import news.wrapper.HappyIdgNewsStub;
import news.wrapper.HappyIdgNewsSummaryStub;
import org.jsoup.nodes.Document;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public class IdgHtmlParserTest {


    @Test
    public void testParseNewsSummaryList(){
        IdgHtmlParser parser = new IdgHtmlParser(new HappyIdgNewsSummaryStub());
        assertTrue(parser.getNewsSummaryList().size() == 100);
    }

    @Test
    public void testParseNews(){
        IdgHtmlParser parser = new IdgHtmlParser(new HappyIdgNewsStub());
        String stubTitle = "Stub title";
        News news = parser.getNewsDetail("http://www.idg.se/2.1085/1.554401/premiar-for-amazons-virtuella-skrivbord", stubTitle);
        assertTrue(!news.getHtml().isEmpty());
        assertTrue(news.getTitle().equals(stubTitle));
    }
}
