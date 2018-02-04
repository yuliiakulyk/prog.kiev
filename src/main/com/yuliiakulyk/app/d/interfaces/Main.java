package main.com.yuliiakulyk.app.d.interfaces;

import java.util.Arrays;

/**
 * Created by Yuliia Kulyk on 03.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        Cat catOne = new Cat("Vaska", 2, "White");
        Cat catTwo = new Cat("Murka", 5, "Red");
        Cat catThree = new Cat("Umka", 10, "Grey");
        Cat catFour = new Cat("Kuzia", 6, "Black");
        Cat catFive = new Cat("Monia", 5, "White");

        Cat[] catArray = new Cat[] {catOne, catTwo, catThree, catFour, catFive};

        for (Cat cat: catArray) {
            System.out.println(cat);
        }

        Arrays.sort(catArray);
        System.out.println();

        for (Cat cat: catArray) {
            System.out.println(cat);
        }

        System.out.println();

        Arrays.sort(catArray, (a, b) -> a.getName().compareTo(b.getName()));

        for (Cat cat: catArray) {
            System.out.println(cat);
        }
    }
}
