import java.util.*;

import ru.shirinkin.consonant.*;
import ru.shirinkin.fraction.*;
import ru.shirinkin.cat.*;
import ru.shirinkin.map.*;
import ru.shirinkin.peoplegrouper.*;
import ru.shirinkin.queue.*;
import ru.shirinkin.geometry.*;

import static ru.shirinkin.streampolyline.StreamPolyline.processPoints;


public class Main {
    long startTime;
    long endTime;
    public static <Polyline> void main(String[] args) {
        long startTime;
        long endTime;

        System.out.println("Выберите задание: " +
                "\n1. CachedFraction " +
                "\n2. Meowable cat" +
                "\n3. Remove if" +
                "\n4. Participants of Olympiada" +
                "\n5. ConsonantLetters" +
                "\n6. Queue segment equal" +
                "\n7. Stream Polyline" +
                "\n8. Group People" +
                "\n0. Выход");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();


        switch (choice) {
            case 1:
                // Кэширование дроби
                System.out.println("--- CachedFraction ---");

                Fraction basic = new Fraction(3, 7);
                CachedFraction cached = new CachedFraction(basic);

                System.out.println("Демонстрация работы кэша:");
                System.out.println("Дробь: " + cached);

                // Первый вызов - вычисление + кэширование
                startTime = System.nanoTime();
                double result1 = cached.getValue();
                endTime = System.nanoTime();
                System.out.println("Первый вызов: " + result1 + "; Время выполнения: " + (endTime - startTime) + " наносекунд");

                // Второй вызов - берем из кэша (должен быть быстрее)
                startTime = System.nanoTime();
                double result2 = cached.getValue();
                endTime = System.nanoTime();
                System.out.println("Второй вызов: " + result2 + "; Время выполнения: " + (endTime - startTime) + " наносекунд");

                // Меняем дробь - кэш сбрасывается
                cached.setNumerator(1);
                System.out.println("\nПосле изменения числителя на 1:");
                System.out.println("Дробь: " + cached);

                // Снова первый вызов - вычисление заново
                startTime = System.nanoTime();
                double result3 = cached.getValue();
                endTime = System.nanoTime();
                System.out.println("Первый вызов: " + result3 + "; Время выполнения: " + (endTime - startTime) + " наносекунд");

                // И снова из кэша
                startTime = System.nanoTime();
                double result4 = cached.getValue();
                endTime = System.nanoTime();
                System.out.println("Второй вызов: " + result4 + "; Время выполнения: " + (endTime - startTime) + " наносекунд");


                break;
            case 2:
                // Сколько раз мяукнул
                System.out.println("--- Meowable cat ---");
                Cat cat = new Cat("Зевс");
                CountingСat countingCat = new CountingСat(cat);

                System.out.println(cat.getName() + " мяукает без приказа");
                Meows.meowsCare(countingCat);
                System.out.println(countingCat.toString());

                System.out.println("\n" + cat.getName() + " мяукает ровно 3 раза");
                Meows.meowsCare(countingCat, 3);
                System.out.println(countingCat.toString());

                break;
            case 3:
                // Составить программу, которая удаляет из списка L все элементы с указанным значением
                System.out.println("--- Remove if ---");
                // Создаём список
                List<Integer> L = new ArrayList<>(List.of(5, 1, 2, 5, 3, 4, 5));
                System.out.println("Исходный список: " + L);

                // Значение, которое нужно удалить
                int valueToRemove = 5;

                // Удаляем элементы с указанным значением (Встроенный метод)
                L.removeIf(n -> n == valueToRemove);

                System.out.println("После удаления: " + L);

                break;
            case 4:
                // Вывести имя+фамилия самых крутых участников
                System.out.println("--- Participants of Olympiada ---");
                WinnersMap wm = new WinnersMap();
                wm.map("SN_FS_points.txt");
                List<String> participants = wm.getScoreboard().get(wm.getMaxScore());

                // Вывод
                if (participants.isEmpty()) {
                    System.out.println("Участников не найдено.");
                } else {
                    System.out.println("Максимальный балл: " + wm.getMaxScore());
                    System.out.println("\nПобедитель(-и): ");
                    for (String p : participants) {
                        System.out.println(p);
                    }
                }

                break;
            case 5:
                // Напечатать в алфавитном порядке все согласные буквы,
                // которые входят ровно в одно слово.
                System.out.println("--- ConsonantLetters ---");
                ConsonantLetters cl = new ConsonantLetters();
                // Прочитали текст, нашли уникальные согласные
                cl.cons("Text.txt");

                // Для удобства чтения
                Set<Character> setChar = cl.getResult();

                if (setChar.isEmpty()) {
                    System.out.println("Нет согласных, встречающихся ровно в одном слове.");
                } else {
                    System.out.println("Согласные, входящие ровно в одно слово (по алфавиту):");
                    for (Character ch : setChar) {
                        System.out.print(ch + " ");
                    }
                }

                break;
            case 6:
                // Проверить равенство участка очереди с i-го по j-й элемент (i < j).
                System.out.println("--- Queue segment equal ---");
                Queue<String> q1 = new LinkedList<>();
                q1.add("A"); // индекс 0
                q1.add("B");
                q1.add("C");
                q1.add("C");
                q1.add("C");
                q1.add("D");
                q1.add("E");

                int i = 2;
                int j = 4;

                System.out.println("Очередь: " + q1);
                boolean result = SegmentEqual.isSegmentEqual(q1, i, j);
                if (result) {
                    System.out.println("Участок очереди с " + i + " по " + j + " состоит из одинаковых элементов.");
                } else {
                    System.out.println("Элементы на участке c " + i + " по " + j + " различаются.");
                }

                i = 1;
                j = 4;
                result = SegmentEqual.isSegmentEqual(q1, i, j);
                if (result) {
                    System.out.println("\nУчасток очереди с " + i + " по " + j + " состоит из одинаковых элементов.");
                } else {
                    System.out.println("Элементы на участке c " + i + " по " + j + " различаются.");
                }

                break;
            case 7:
                // Отсортировать по Х. Выкинуть дубликаты. Отрицательные У сделать положительными
                System.out.println("--- Stream Polyline---");
                List<Point> points = Arrays.asList(
                        new Point(3, -2),
                        new Point(1, 4),
                        new Point(3, -2), // Дубликат
                        new Point(2, -5),
                        new Point(1, 4),  // Дубликат
                        new Point(0, 3),
                        new Point(-1, -7)
                );

                System.out.println("Исходные точки: " + points);

                ru.shirinkin.geometry.Polyline polyline = processPoints(points);
                System.out.println("Результирующая ломаная: " + polyline);

                break;
            case 8:
                // Даны имя человека и номер его группы. Рассортировать по группам с условиями.
                System.out.println("--- Group People ---");
                try {
                    Map<String, List<String>> res = PeopleGrouper.groupPeopleByNumber("People.txt");
                    for (Map.Entry<String, List<String>> entry : res.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                } catch (Exception e) {
                    System.err.println("Ошибка: " + e.getMessage());
                }

                break;
            default:
                System.out.println("Выход...");
                break;
        }
    }
}
