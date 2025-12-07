package ru.shirinkin.geometry;
public class Line {
    private Point start;
    private Point end;

    //properties
    public Point getStart() {
        return new Point(this.start);
    }

    public Point getEnd() {
        return new Point(this.end);
    }

    public void setStart(Point start) {
        this.start = start;
    }
    public void setEnd(Point end) {
        this.end = end;
    }

    //constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line() {
        this.start = new Point(0, 0);
        this.end = new Point(0, 0);
    }

    //methods
    @Override
    public String toString() {
        return "Линия от " + this.start.toString() + " до " + this.end.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            Line line = (Line) obj;
            return this.start.equals(line.start) && this.end.equals(line.end);
        }
        return false;
    }
}
