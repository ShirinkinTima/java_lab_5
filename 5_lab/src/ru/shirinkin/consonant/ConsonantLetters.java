package ru.shirinkin.consonant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ConsonantLetters {
    // Все согласные алфавита
    private static final String consonants = "бвгджзйклмнпрстфхцчшщ";
    // TreeSet, чтобы буквы сразу были отсортированы по алфавиту
    private static Set<Character> result = new TreeSet<>();

    public static Set<Character> getResult() {
        return result;
    }

    public static void cons(String fileName) {
        File file = new File(fileName);
        // Буква -> Набор слов, в котором она встречается
        Map<Character, Set<String>> letterWords = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            //  Считать разделителем любые символы, кроме русских букв
            //  Удаляет пробелы, точки, запятые и переводы строк, выдавая чистые слова
            scanner.useDelimiter("[^а-яА-ЯёЁ]+");

            // Пока есть слова
            while (scanner.hasNext()) {
                // Сразу в один регистр, чтобы не путаться
                String word = scanner.next().toLowerCase();

                // Уникальные согласные внутри текущего слова
                Set<Character> uniqueConsonantsFromWord = new HashSet<>();
                for (char c : word.toCharArray()) {
                    // Если согласная
                    if (consonants.indexOf(c) != -1) {
                        uniqueConsonantsFromWord.add(c);
                    }
                }

                // Запись каждой уникальной согласной из слова в Map
                for (char c : uniqueConsonantsFromWord) {
                    letterWords.putIfAbsent(c, new HashSet<>());
                    letterWords.get(c).add(word);
                }
            }

            // Перебираем пары Буква -> набор слов
            for (Map.Entry<Character, Set<String>> entry : letterWords.entrySet()) {
                // Если размер множества слов == 1, значит буква была ровно в одном слове
                if (entry.getValue().size() == 1) {
                    result.add(entry.getKey());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
        }
    }
}