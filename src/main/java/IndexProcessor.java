import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndexProcessor {

    public Indexer getIndexer() {
        return indexer;
    }

    Indexer indexer = new Indexer();


    public List<String> loadPagesAddresses(String myFile) {

        List<String> pageContent = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(myFile);


        if (resource != null) {
            File file = new File(resource.getFile());
            try {
                Scanner pageReader = new Scanner(file);
                while (pageReader.hasNextLine()) {
                    pageContent.add(pageReader.nextLine());
                }
                pageReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return pageContent;
    }

    public void buildIndex(List<String> pageContent) {

        for (String address : pageContent) {
            indexer.addPageToIndex(address);
        }


    }


}

