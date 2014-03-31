package news.service;

import news.parser.HtmlParser;
import news.parser.IdgHtmlParser;
import news.wrapper.RealJsoupWrapper;
import news.wrapper.WrapperStub;
import org.junit.Test;
import static org.junit.Assert.*;


import java.io.IOException;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class NewsServiceImplIntegrationTest {
    @Test
    public void fetchedLatestNewsIdgIsOK() throws IOException {
        HtmlParser parser = new IdgHtmlParser(new RealJsoupWrapper());
        NewsService service = new NewsServiceImpl(parser);
        assertTrue(service.fetchLatestNews().size() > 0);
    }


}
