public class WordFrequencyApp {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        counter.addText("Java is fun. Java is hard!  But java is worth it.");

        System.out.println("Count of 'java': " + counter.getCount("java"));
        System.out.println("Count of 'is': " + counter.getCount("is"));
        System.out.println("Count of 'fun': " + counter.getCount("fun"));
        System.out.println("Unique words: " + counter.getUniqueWordCount());
    }
}