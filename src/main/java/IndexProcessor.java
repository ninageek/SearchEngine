import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndexProcessor {


    public List<String> loadPagesAddresses(String myFile) {

        List<String> pageContent = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(myFile).getFile());
        try {
            Scanner pageReader = new Scanner(file);
            while (pageReader.hasNextLine()) {
                pageContent.add(pageReader.nextLine());
            }
            pageReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pageContent;
    }


}

