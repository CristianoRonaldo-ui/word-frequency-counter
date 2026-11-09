import java.util.HashMap;

public class WordCounter {
    private HashMap<String, Integer> counts;

    public WordCounter() {
        counts = new HashMap<>();
    }

    public int getUniqueWordCount() {
        return counts.size();
    }

    public void addWord(String word) {
        String key = word.toLowerCase();
        int current = counts.getOrDefault(key, 0);
        counts.put(key, current + 1);
    }

    public int getCount(String word) {
        return counts.getOrDefault(word.toLowerCase(), 0);
    }
}