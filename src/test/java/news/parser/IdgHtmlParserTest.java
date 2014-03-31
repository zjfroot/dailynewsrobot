package news.parser;

import news.model.News;
import news.model.NewsSummary;
import news.wrapper.WrapperStub;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public class IdgHtmlParserTest {


    @Test
    public void testParseNewsSummaryListOK() throws IOException {
        IdgHtmlParser parser = new IdgHtmlParser(new WrapperStub("/testParseNewsSummaryListOK.html"));
        assertTrue(parser.getNewsSummaryList().size() == 100);
    }

    /*@Test
    public void testParseNewsSummaryListNOK_htmlChanged() throws IOException {
        IdgHtmlParser parser = new IdgHtmlParser(new WrapperStub("/testParseNewsSummaryListOK.html"));
        assertTrue(parser.getNewsSummaryList().size() == 100);
    }*/

    @Test
    public void testParseNewsOK() throws IOException {
        IdgHtmlParser parser = new IdgHtmlParser(new WrapperStub("/testParseNewsOK.html"));
        String stubTitle = "Stub title";
        News news = parser.getNewsDetail(new NewsSummary(stubTitle, "http://www.idg.se/2.1085/1.554401/premiar-for-amazons-virtuella-skrivbord"));
        assertTrue(!news.getHtml().isEmpty());
        assertTrue(news.getTitle().equals(stubTitle));
    }
}
