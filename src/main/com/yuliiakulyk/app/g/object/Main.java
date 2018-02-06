package main.com.yuliiakulyk.app.g.object;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Yuliia Kulyk on 06.02.2018.
 */
public class Main {
    public static Cat mainCat;

    public static void main(String[] args) {
        Cat catOne = new Cat("Vaska", 4, "white");
        Cat catTwo = new Cat("Vaska", 4, "white");
        System.out.println(catOne);

        System.out.println(catOne == catTwo);
        System.out.println(catOne.equals(catTwo));
        Cat catThree = null;

        try {
            catThree = catOne.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Clone of catOne:");
        System.out.println(catThree);
        System.out.println(catThree == catOne);

        System.out.println();

        Class catClass = catOne.getClass();
        Field[] fields = catClass.getDeclaredFields();
        for (Field field:fields
             ) {
            System.out.println(field);
        }
        System.out.println();
        Method[] methods = catClass.getDeclaredMethods();
        for (Method method:methods
             ) {
            System.out.println(method);
        }

        System.out.println();
        Constructor[] constructors = catClass.getDeclaredConstructors();
        for (Constructor constructor: constructors
             ) {
            System.out.println(constructor);
        }

        try {
            Field catAge = catClass.getDeclaredField("age");
            catAge.setAccessible(true);
            catAge.setInt(catOne, 117);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(catOne);

        try {
            ObjectFileWorker.saveObjectToFile(new File("src/main/com/yuliiakulyk/app/g/object/cat.dat"), catOne);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Cat catRestored = null;
        try {
            catRestored = (Cat) ObjectFileWorker.loadObjectFromFile(new File("src/main/com/yuliiakulyk/app/g/object/cat.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Restored cat from file:");
        System.out.println(catRestored);

        catOne = null;

        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(mainCat);

        mainCat = null;

        System.gc();

        System.out.println(mainCat);

        System.out.println("Main stopped");

    }
}