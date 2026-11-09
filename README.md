# Word Frequency Counter

A Java command-line program that counts how often each word appears in a piece of text, using a `HashMap<String, Integer>`.

## Features

- Counts words **case-insensitively** ("Java" and "java" are the same word)
- Strips punctuation (`fun.` → `fun`, `hard!` → `hard`)
- Ignores extra spaces between words
- Finds the **most frequent word**
- Reports the number of **unique words**
- Includes manual PASS/FAIL tests

## Project Structure

```
word-frequency-counter/
├── src/
│   ├── WordCounter.java        # Core logic: HashMap-based counting
│   └── WordFrequencyApp.java   # Demo program + manual tests
├── .gitignore
└── README.md
```

## How to Run

Requires Java (JDK 17 or later).

```bash
javac src/*.java
java -cp src WordFrequencyApp
```

## Example Output

Input text: `"Java is fun. Java is hard!  But java is worth it."`

```
Count of 'java': 3
Count of 'is': 3
Count of 'fun': 1
Unique words: 7
Most frequent: java

=== Running tests ===
Test 1 PASS: case-insensitive counting
Test 2 PASS: punctuation and extra spaces ignored
Test 3 PASS: empty counter returns empty string
```


## Complexity Analysis

Let `n` = number of words in the text, `u` = number of unique words.

| Method | Time | Why |
|---|---|---|
| `addWord` | O(1) average | One `getOrDefault` + one `put` on a HashMap |
| `getCount` | O(1) average | One HashMap lookup |
| `addText` | O(n) | Calls `addWord` once per word |
| `getMostFrequentWord` | O(u) | Loops over every unique key once |
| `getUniqueWordCount` | O(1) | `size()` is stored, not recalculated |

Space: O(u) — the HashMap stores one entry per unique word.

## What I Learned

- **HashMap is Java's version of Python's `dict`.** `getOrDefault(key, 0)` ↔ `dict.get(key, 0)`, `put(key, value)` ↔ `dict[key] = value`.
- **Generics need object types:** `HashMap<String, Integer>` works, `HashMap<String, int>` does not compile.
- **`get()` returns `null` for missing keys** instead of throwing like Python's `KeyError`. Writing `counts.get(key) + 1` on a new word causes a `NullPointerException` at runtime — `getOrDefault` avoids this.
- **HashMap does not keep insertion order.** `keySet()` iterates in hash-bucket order, not the order words appeared. In my demo, `java` and `is` both appear 3 times; `java` wins only because it happens to be visited first and I used `>` (ties keep the earlier word). Lesson: never rely on HashMap order — use `LinkedHashMap` when order matters.
- **Edge cases from `split(" ")`:** two spaces in a row produce an empty string `""`, so I check `isEmpty()` before counting.
- **Compiling is not the same as working.** When my `if` block was still a `// TODO` comment, the code compiled fine but printed an empty result — running and checking output caught it.
- **Compare Strings with `.equals()`**, not `==`.