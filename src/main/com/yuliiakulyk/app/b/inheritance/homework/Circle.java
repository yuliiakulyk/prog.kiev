package main.com.yuliiakulyk.app.b.inheritance.homework;

/**
 * Created by Yuliia Kulyk on 17.01.2018.
 */
public class Circle extends Shape {
    private Point center;
    private Point pointOnCircle;

    public Circle(Point center, Point pointOnCircle) {
        this.center = center;
        this.pointOnCircle = pointOnCircle;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getPointOnCircle() {
        return pointOnCircle;
    }

    public void setPointOnCircle(Point pointOnCircle) {
        this.pointOnCircle = pointOnCircle;
    }

    public Circle() {
        this.center = new Point(0.0, 0.0);
        this.pointOnCircle = new Point(1.0, 1.0);
    }

    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * Shape.getDistance(center, pointOnCircle);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(Shape.getDistance(center, pointOnCircle), 2.0);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", pointOnCircle=" + pointOnCircle +
                '}';
    }
}
