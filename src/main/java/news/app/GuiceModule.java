package news.app;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.PrivateModule;
import com.google.inject.name.Names;
import news.parser.HtmlParser;
import news.parser.IdgHtmlParser;
import news.parser.SvdHtmlParser;
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
        install(privateModuleFor("IdgService", IdgHtmlParser.class));
        install(privateModuleFor("SvdService",SvdHtmlParser.class));
    }

    private static Module privateModuleFor(
            final String serviceName, final Class<? extends HtmlParser> htmlParser) {
        return new PrivateModule() {
            @Override protected void configure() {
                // Bind the annotated user.
                bind(NewsService.class).annotatedWith(Names.named(serviceName)).to(NewsServiceImpl.class);
                // Now bind the music class as if it's the only music class ever.
                bind(HtmlParser.class).to(htmlParser);
                // The above two bindings are hidden, and available only in this module,
                // so Guice doesn't complain about two different competing
                // MusicInterfaces. In order to get access to the User binding
                // outside the module, expose it.
                expose(NewsService.class).annotatedWith(Names.named(serviceName));
            }
        };
    }
}
