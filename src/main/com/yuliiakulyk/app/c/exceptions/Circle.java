package main.com.yuliiakulyk.app.c.exceptions;

/**
 * Created by Yuliia Kulyk on 18.01.2018.
 */
public class Circle {
    public static void main(String[] args) {
        System.out.println(getArea(1));
        System.out.println(getArea(-1));
    }

    public static double getArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Negative radius") ;
        }
        return radius * radius * Math.PI;
    }
}
