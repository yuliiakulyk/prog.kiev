package main.com.yuliiakulyk.app.a.classes;

/**
 * Created by Yuliia Kulyk on 15.01.2018.
 *
 * Описать класс «Triangle». В качестве свойств возьмите длины сторон
 треугольника. Реализуйте метод, который будет возвращать площадь этого
 треугольника. Создайте несколько объектов этого класса и протестируйте их.
 */
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
       if ((a < b + c) && (b < a + c) && (c < a + b) && a != 0 && b != 0 && c != 0) {
           this.a = a;
           this.b = b;
           this.c = c;
       } else {
           throw new IllegalArgumentException("a side cannot be 0 or more than sum of other sides");
       }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if ((a == 0) || (a > this.b + this.c)) {
            throw new IllegalArgumentException("'a' cannot be 0 or more than sum of other sides");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if ((b == 0) || (b > this.a + this.c)) {
            throw new IllegalArgumentException("'b' cannot be 0 or more than sum of other sides");
        }
        this.b = b;

    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if ((c == 0) || (c > this.a + this.b)) {
            throw new IllegalArgumentException("'c' cannot be 0 or more than sum of other sides");
        }
        this.c = c;
    }

    public double area() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
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
