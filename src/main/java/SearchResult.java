import java.util.Objects;

public class SearchResult {
    String link;
    String context;

    public SearchResult(String link, String context) {
        this.link = link;
        this.context = context;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return link.equals(that.link) &&
                context.equals(that.context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, context);
    }
}
