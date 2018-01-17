package main.com.yuliiakulyk.app.b.inheritance.homework;

/**
 * Created by Yuliia Kulyk on 17.01.2018.
 */
public class Board {
    private Shape[] shapes;

    public Board() {
        this.shapes = new Shape[4];
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public void putShape(int part, Shape shape) {
        if (part < 1 || part > shapes.length) {
            System.out.println("There are only 4 parts in the board. Please, specify a part from 1 to 4.");
        } else if (shapes[part - 1] != null) {
            System.out.println("There is already a shape in part # " + part);
        } else {
            shapes[part - 1] = shape;
            System.out.println("Shape " + shape + " was put to part # " + part);
        }
    }

    public void removeShape(int part) {
        if (part < 1 || part > shapes.length) {
            System.out.println("There are only 4 parts in the board. Please, specify a part from 1 to 4.");
        } else if (shapes[part - 1] == null) {
            System.out.println("Part # " + part + " is already empty.");
        } else {
            shapes[part - 1] = null;
            System.out.println("Cleared part # " + part);
        }
    }

    public void printShapesInfo() {
        System.out.println("Shapes info:");
        double totalArea = 0;
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape != null) {
                totalArea += shape.getArea();
            }
        }
        System.out.println("Total area: " + totalArea);
    }
}
