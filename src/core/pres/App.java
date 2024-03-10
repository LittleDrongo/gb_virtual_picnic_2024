package core.pres;

import core.Config;
import core.model.Basket;
import core.model.Worlds;

import java.io.FileNotFoundException;
import java.util.Map;

public class App {

    public void run(){

        Basket basket = new Basket(Config.INPUT_FILE_PATH);

        try {
            int wordCount = basket.countWords();
            System.out.println("Количество слов в файле: " + wordCount);

            Worlds longestWord = basket.findLongestWord();
            System.out.println("Самое длинное слово в файле: " + longestWord.getTitle());

            Map<String, Integer> wordFrequency = basket.calculateWordFrequency();
            System.out.println("Частота слов в файле:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }


    }
}
