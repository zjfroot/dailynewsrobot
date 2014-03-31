package news.wrapper;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jifeng Zhang on 3/31/14.
 */
public class WrapperStub implements JsoupWrapper {

    String stubFilePath;

    public WrapperStub(String stubFilePath) {
        this.stubFilePath = stubFilePath;
    }

    @Override
    public Document get(String url) throws IOException {
        InputStream is = this.getClass().getResourceAsStream(stubFilePath);
        return Jsoup.parse(IOUtils.toString(is, "UTF-8"));
    }
}
