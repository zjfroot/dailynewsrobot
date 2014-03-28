package news.parser;

import news.FakeJsoupWrapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public class IdgHtmlParserTest {

    @Test
    public void testParseRightFormattedNewsSummaryList(){
        IdgHtmlParser parser = new IdgHtmlParser(new FakeJsoupWrapper("idg","happy"));
        assertTrue(parser.getNewsSummaryList().size() == 100 );
    }
}
