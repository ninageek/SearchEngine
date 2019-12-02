public class HtmlParser {

    String parseHtml(String html) {
        return html.replaceAll("<.*?>", " ").replaceAll(" +", " ").trim();
    }
}
