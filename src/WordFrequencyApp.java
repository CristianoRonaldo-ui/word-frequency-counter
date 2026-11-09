public class WordFrequencyApp {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        counter.addWord("Java");
        counter.addWord("java");
        counter.addWord("Python");

        System.out.println("Count of 'java': " + counter.getCount("java"));
        System.out.println("Count of 'python': " + counter.getCount("Python"));
        System.out.println("Count of 'c++': " + counter.getCount("c++"));
        System.out.println("Unique words: " + counter.getUniqueWordCount());
    }
}