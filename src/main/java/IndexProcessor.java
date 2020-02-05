import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndexProcessor {

    public Index getIndex() {
        return index;
    }

    Index index = new Index();


    public List<String> loadPagesAddresses(String myFile) {

        List<String> pagesAddress = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(myFile);


        if (resource != null) {
            File file = new File(resource.getFile());
            try {
                Scanner pageReader = new Scanner(file);
                while (pageReader.hasNextLine()) {
                    pagesAddress.add(pageReader.nextLine());
                }
                pageReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return pagesAddress;
    }

    public void buildIndex(List<String> pagesAddress) {

        for (String address : pagesAddress) {
            index.addPageToIndex(address);
        }


    }


}

