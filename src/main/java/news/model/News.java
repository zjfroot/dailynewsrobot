package news.model;

/**
 * Created by Jifeng Zhang on 3/26/14.
 */
public class News {
    Integer id;
    Integer categoryId;
    String title;
    String html;

    public News(String title, String html) {
        this.title = title;
        this.html = html;
    }
}
