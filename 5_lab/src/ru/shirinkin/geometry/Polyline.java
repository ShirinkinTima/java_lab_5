package ru.shirinkin.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    //properties
    public List<Point> getPoints() {
        return new ArrayList<Point>(this.points);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    //constructors
    public Polyline() {
        this.points = new ArrayList<>();
    }

    public Polyline(List<Point> points) {
        this.points = points;
    }

    //methods
    @Override
    public String toString() {
        return "Линия [" + points + "]";
    }
}
