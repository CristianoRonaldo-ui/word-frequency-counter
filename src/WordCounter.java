import java.util.HashMap;

public class WordCounter {
    private HashMap<String, Integer> counts;

    public WordCounter() {
        counts = new HashMap<>();
    }

    public int getUniqueWordCount() {
        return counts.size();
    }
}