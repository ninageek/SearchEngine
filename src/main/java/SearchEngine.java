import java.util.List;

public class SearchEngine {

    IndexProcessor processor = new IndexProcessor();

    public IndexProcessor getProcessor() {
        return processor;
    }

    public void updateIndex(String pages){
        List<String> pageContent = processor.loadPagesAddresses(pages);
        processor.buildIndex(pageContent);
    }

    public List<String> search(String term){
        return null;
    }

}
