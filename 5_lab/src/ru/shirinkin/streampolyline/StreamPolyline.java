package ru.shirinkin.streampolyline;

import ru.shirinkin.geometry.Point;
import ru.shirinkin.geometry.Polyline;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPolyline {
    public static Polyline processPoints(List<Point> points) {
        List<Point> processedPoints = points.stream()
                // Убираем точки с одинаковыми координатами
                .distinct()
                // Сортируем по x
                .sorted(Comparator.comparingInt(Point::getX))
                // Отрицательные y делаем положительными
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                // Собираем в список
                .collect(Collectors.toList());

        return new Polyline(processedPoints);
    }
}
