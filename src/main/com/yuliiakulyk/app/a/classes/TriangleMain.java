package main.com.yuliiakulyk.app.a.classes;

/**
 * Created by Yuliia Kulyk on 15.01.2018.
 */
public class TriangleMain {
    public static void main(String[] args) {
        Triangle t1 = new Triangle(4,5,6);
        System.out.println(t1);
        System.out.println("area is " + t1.area());
        t1.setA(100);
    }
}
