package ru.shirinkin.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WinnersMap {
    // Ключ = баллы, Значение = Фамилия + Имя
    static HashMap<Integer, List<String>> scoreboard = new HashMap<>();
    static Integer maxScore;

    public static HashMap<Integer, List<String>> getScoreboard() {
        return scoreboard;
    }

    public static Integer getMaxScore() {
        return maxScore;
    }

    public void map(String fileName) {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {

            // Есть ли данные в файле
            if (!scanner.hasNextInt()) {
                System.out.println("Файл пуст или имеет неверный формат.");
                return;
            }

            // Количество участников
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                // Читаем
                String lastName = scanner.next();
                String firstName = scanner.next();
                int s1 = scanner.nextInt();
                int s2 = scanner.nextInt();
                int s3 = scanner.nextInt();

                int totalScore = s1 + s2 + s3;
                String fullName = lastName + " " + firstName;

                // Добавляем в Map
                scoreboard.putIfAbsent(totalScore, new ArrayList<>());
                scoreboard.get(totalScore).add(fullName);
            }
            maxScore = Collections.max(scoreboard.keySet());

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден!");
        }
    }
}
