package main.com.yuliiakulyk.app.a.classes;

/**
 * Created by Yuliia Kulyk on 11.01.2018.
 */
public class CarMain {
    public static void main(String[] args) {
        Car carOne = new Car();
        carOne.setColor("Red");
        carOne.setWeight(2000);
        carOne.setYear(1981);
        System.out.println(carOne);

        System.out.println(carOne);

        Car carTwo = new Car("Blue", 1500, 2011);
        System.out.println(carTwo);
    }
}
