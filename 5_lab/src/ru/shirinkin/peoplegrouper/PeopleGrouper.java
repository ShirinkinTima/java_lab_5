package ru.shirinkin.peoplegrouper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleGrouper {
    public static Map<String, List<String>> groupPeopleByNumber(String filename) throws IOException {
        // Открывает файл и создает поток (Stream) из всех его строк.
        // Это ленивая операция (строки читаются по мере необходимости)
        return Files.lines(Paths.get(filename))
                // Каждая строка (например, "ivan: 123") превращается
                // в массив строк из двух элементов: ["ivan", " 123"]
                .map(line -> line.split(":"))

                // Защита от плохих данных. Оставляет только те массивы, в которых ровно 2 элемента
                // Если в строке не было двоеточия или их было много, строка отбрасывается
                .filter(parts -> parts.length == 2)

                // Проверяет, что вторая часть (номер) не пустая
                // Если строка была "ivan: ", она будет отброшена
                .filter(parts -> !parts[1].trim().isEmpty())

                // Приведение данных к красивому виду
                .map(parts -> {
                    String name = parts[0].trim().toLowerCase();
                    if (!name.isEmpty()) {
                        name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    }
                    // Объединяем имя и номер в строку для distinct
                    return name + ":" + parts[1].trim();
                })

                // Убираем дубликаты
                .distinct()

                // Обратно разбиваем на массив
                .map(line -> line.split(":"))

                //Превращает поток данных в Map<String, List<String>>
                .collect(Collectors.groupingBy(
                        parts -> parts[1],
                        Collectors.mapping(
                                parts -> parts[0],
                                Collectors.toList()
                        )
                ));
    }
}
