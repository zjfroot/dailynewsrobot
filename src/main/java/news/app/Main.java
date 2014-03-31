package news.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import news.parser.HtmlParser;
import news.parser.IdgHtmlParser;
import news.service.NewsService;
import news.service.NewsServiceImpl;
import news.wrapper.RealJsoupWrapper;

import java.io.IOException;

/**
 * Created by Jifeng Zhang on 3/31/14.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Injector injector = Guice.createInjector(new GuiceModule());
        NewsService idgService = injector.getInstance(Key.get(NewsService.class, Names.named("IdgService")));
        while(true){
            try {
                idgService.fetchLatestNews();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

    }
}
