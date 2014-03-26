package news.model;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class NewsSummary {
    String title;
    String url;

    public NewsSummary(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
