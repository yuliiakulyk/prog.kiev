package main.com.yuliiakulyk.app.b.inheritance.homework;

/**
 * Created by Yuliia Kulyk on 17.01.2018.
 */
public class Square extends Shape {
    private Point center;
    private Point apex;

    public Square(Point center, Point apex) {
        this.center = center;
        this.apex = apex;
    }

    public Square() {
        this.center = new Point(0.0, 0.0);
        this.apex = new Point(1.0, 1.0);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getApex() {
        return apex;
    }

    public void setApex(Point apex) {
        this.apex = apex;
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(2 * Math.pow(getDistance(center, apex), 2.0)) * 4;
    }

    @Override
    public double getArea() {
        return Math.pow(Math.sqrt(2 * Math.pow(getDistance(center, apex), 2.0)), 2.0);
    }

    @Override
    public String toString() {
        return "Square{" +
                "center=" + center +
                ", apex=" + apex +
                '}';
    }
}
