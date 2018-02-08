package main.com.yuliiakulyk.app.h.generics.collections;

import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 08.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        SomeClass<Integer> someClass = new SomeClass<>(100);
        int number = 200 + (Integer) someClass.getSomeField();
        System.out.println(number);
        System.out.println(someClass);

        SomeClass<String> someClass1 = new SomeClass<>("Hello World!");
        someClass1.setSomeField("Java");
        System.out.println(someClass1);

        print(someClass1);
    }

    public static void print(SomeClass<? extends String> a) {
        System.out.println(a);
    }
}
