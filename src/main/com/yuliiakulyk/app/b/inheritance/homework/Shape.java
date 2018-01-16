package main.com.yuliiakulyk.app.b.inheritance.homework;

/**
 * Created by Yuliia Kulyk on 16.01.2018.
 */
public abstract class Shape {
    public abstract double getPerimeter();
    public abstract double getArea();

    public static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2.0) + Math.pow(b.getY() - a.getY(), 2.0));
    }
}
