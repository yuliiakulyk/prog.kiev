package main.com.yuliiakulyk.app.b.inheritance.homework;

/**
 * Created by Yuliia Kulyk on 16.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);
        System.out.println("area: " + triangle.getArea());

        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println("area: " + circle.getArea());

        Square square = new Square();
        System.out.println(square);
        System.out.println("area: " + square.getArea());

        Board board = new Board();
        board.putShape(100, triangle);
        board.putShape(1, triangle);
        board.putShape(1, triangle);
        board.putShape(2, circle);
        board.putShape(3, square);
        System.out.println(board);
        board.removeShape(1);
        board.removeShape(1);
        System.out.println(board);
    }
}
