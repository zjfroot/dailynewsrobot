package news.app;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import news.parser.HtmlParser;
import news.parser.IdgHtmlParser;
import news.service.NewsService;
import news.service.NewsServiceImpl;
import news.wrapper.JsoupWrapper;
import news.wrapper.RealJsoupWrapper;

/**
 * Created by Jifeng Zhang on 3/31/14.
 */
public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(JsoupWrapper.class).to(RealJsoupWrapper.class);
        //bind(HtmlParser.class).annotatedWith(Names.named("IdgHtmlParser")).to(IdgHtmlParser.class);
        bind(HtmlParser.class).to(IdgHtmlParser.class);
        //bind(HtmlParser.class).annotatedWith(Names.named("SvdHtmlParser")).to(IdgHtmlParser.class);
        bind(NewsService.class).to(NewsServiceImpl.class);
    }
}
