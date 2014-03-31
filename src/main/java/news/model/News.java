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

    public Integer getId() {
        return id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public String getHtml() {
        return html;
    }
}
