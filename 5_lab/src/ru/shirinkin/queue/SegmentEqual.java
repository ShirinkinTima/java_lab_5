package ru.shirinkin.queue;

import java.util.Iterator;
import java.util.Queue;

public class SegmentEqual {
    public static <T> boolean isSegmentEqual(Queue<T> queue, int i, int j) {
        // Проверки на корректность входных данных
        if (queue == null || queue.isEmpty()) {
            return false;
        }
        if (i < 0 || j >= queue.size() || i >= j) {
            System.out.println("Некорректные индексы");
            return false;
        }

        Iterator<T> iterator = queue.iterator();
        T firstValue = null;
        int currentIndex = 0;
        boolean firstFound = false;

        while (iterator.hasNext()) {
            T element = iterator.next();

            // Если мы в начале участка
            if (currentIndex == i) {
                firstValue = element;
                firstFound = true;
            }

            // Если мы находимся внутри участка
            if (currentIndex > i && currentIndex <= j) {
                // Если элемент не равен firstValue, возвращаем false
                if (firstValue != null && !firstValue.equals(element)) {
                    return false;
                }
                // Если firstValue был null, а текущий не null - тоже не равны
                if (firstValue == null && element != null) {
                    return false;
                }
            }

            // Если мы прошли индекс j
            if (currentIndex > j) {
                break;
            }

            currentIndex++;
        }

        // Если i был больше размера очереди, firstFound будет false
        return firstFound;
    }
}