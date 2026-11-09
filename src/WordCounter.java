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

    public void addText(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            String cleaned = word.replaceAll("[^a-zA-Z]", "");
            if (!cleaned.isEmpty()) {
                addWord(cleaned);
            }
        }
    }

    public String getMostFrequentWord() {
        String bestWord = "";
        int bestCount = 0;

        for (String word : counts.keySet()) {
            int count = counts.get(word);
            if (count > bestCount) {
                bestWord = word;
                bestCount = count;
            }
        }

        return bestWord;
    }
}