package news;

import news.api.JsoupWrapper;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jifeng Zhang on 3/28/14.
 */
public class FakeJsoupWrapper implements JsoupWrapper {
    private String type;
    private String scenario;

    public FakeJsoupWrapper(String type, String scenario) {
        this.type = type;
        this.scenario = scenario;
    }

    @Override
    public Document getNewsSummary(String url) {
        if(scenario.equals("happy")){
            switch (type){
                case "idg":
                    InputStream is = this.getClass().getResourceAsStream("/IdgNewsSummaryGoodHtml.html");
                    try {
                        return Jsoup.parse(IOUtils.toString(is, "UTF-8"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case "svd":
                    return Jsoup.parse("svd good html");
                default:
                    throw new IllegalArgumentException("Choose idg or svd");
            }
        }else if(scenario.equals("sad")){
            switch (type){
                case "idg":
                    return Jsoup.parse("idg bad html");
                case "svd":
                    return Jsoup.parse("svd bad html");
                default:
                    throw new IllegalArgumentException("Choose idg or svd");
            }
        }else{
            throw new IllegalArgumentException("Choose happy or sad");
        }
    }
}
