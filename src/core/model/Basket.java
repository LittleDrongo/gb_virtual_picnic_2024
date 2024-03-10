package core.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private final String filePath;

    public Basket(String filePath) {
        this.filePath = filePath;
    }

    public int countWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        int count = 0;
        while (scanner.hasNext()) {
            scanner.next().toLowerCase(); // Приведение слова к нижнему регистру перед подсчетом
            count++;
        }
        scanner.close();
        return count;
    }

    public Worlds findLongestWord() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        Worlds longestWord = new Worlds();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase(); // Приведение слова к нижнему регистру перед сравнением
            if (longestWord.getTitle() == null || word.length() > longestWord.getLength()) {
                longestWord.setTitle(word);
                longestWord.setLength(word.length());
            }
        }
        scanner.close();
        return longestWord;
    }

    public Map<String, Integer> calculateWordFrequency() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        Map<String, Integer> wordFrequency = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase(); // Приведение слова к нижнему регистру перед добавлением или сравнением
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        scanner.close();
        return wordFrequency;
    }
}