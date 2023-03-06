package task3;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Reader {
    private final InputStream is;
    private final Map<String, Integer> words;

    public Reader(InputStream is) {
        this.is = is;
        words = new HashMap<>();
    }

    private Map<String, Integer> readWords() throws IOException {
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }

        is.close();
        scanner.close();

        return words;
    }

    public void printWords() throws IOException {
        Map<String, Integer> result = sortWords(readWords());

        for (Map.Entry<String, Integer> entry: result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private Map<String, Integer> sortWords(Map<String, Integer> elements) {
        Map<String, Integer> sortedWords = new TreeMap<>(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (words.get(o1) <= words.get(o2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        sortedWords.putAll(words);

        return sortedWords;
    }
}
