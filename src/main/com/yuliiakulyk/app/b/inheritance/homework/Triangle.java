package main.com.yuliiakulyk.app.b.inheritance.homework;

/**
 * Created by Yuliia Kulyk on 16.01.2018.
 */
public class Triangle extends Shape {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {
        this.a = new Point(1.0, 0.0);
        this.b = new Point(-1.0, 0.0);
        this.c = new Point(0.0, 1.0);
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return Shape.getDistance(a, b) + Shape.getDistance(a, c) + Shape.getDistance(b, c);
    }

    @Override
    public double getArea() {
        double ab = Shape.getDistance(a, b);
        double ac = Shape.getDistance(a, c);
        double bc = Shape.getDistance(b, c);
        double p = (ab + ac + bc) / 2.0;
        return Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}