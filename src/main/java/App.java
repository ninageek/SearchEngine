import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.updateIndex(Config.PAGES);
        while (true) {
            System.out.println("Enter the search word: ");
            String term = scanner.nextLine();
            List<String> ret = searchEngine.search(Config.PAGES, term);
            if (ret != null && !ret.isEmpty()) {
                for (String result : ret) {
                    System.out.println(result);
                }
            } else {
                System.out.println("Your search term was not found. Enter a new word to search:");
            }
        }


    }
}
