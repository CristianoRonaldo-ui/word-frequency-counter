public class WordFrequencyApp {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        counter.addText("Java is fun. Java is hard!  But java is worth it.");

        System.out.println("Count of 'java': " + counter.getCount("java"));
        System.out.println("Count of 'is': " + counter.getCount("is"));
        System.out.println("Count of 'fun': " + counter.getCount("fun"));
        System.out.println("Unique words: " + counter.getUniqueWordCount());
        System.out.println("Most frequent: " + counter.getMostFrequentWord());

        runTests();
    }

    public static void runTests() {
        System.out.println();
        System.out.println("=== Running tests ===");

        // Test 1: counting ignores upper/lower case
        WordCounter c1 = new WordCounter();
        c1.addText("Apple apple APPLE");
        if (c1.getCount("apple") == 3) {
            System.out.println("Test 1 PASS: case-insensitive counting");
        } else {
            System.out.println("Test 1 FAIL: expected 3, got " + c1.getCount("apple"));
        }

        // Test 2: punctuation and extra spaces are ignored
        WordCounter c2 = new WordCounter();
        c2.addText("Hi!  Hi... hi?");
        if (c2.getCount("hi") == 3 && c2.getUniqueWordCount() == 1) {
            System.out.println("Test 2 PASS: punctuation and extra spaces ignored");
        } else {
            System.out.println("Test 2 FAIL: expected 3 and 1, got "
                    + c2.getCount("hi") + " and " + c2.getUniqueWordCount());
        }

        // Test 3: empty counter returns empty string
        WordCounter c3 = new WordCounter();
        if (c3.getMostFrequentWord().equals("")) {
            System.out.println("Test 3 PASS: empty counter returns empty string");
        } else {
            System.out.println("Test 3 FAIL: expected empty string");
        }
    }
}