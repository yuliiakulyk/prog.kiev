package main.com.yuliiakulyk.app.h.generics.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 08.02.2018.
 */
public class MainLists {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        System.out.println(list);
        list.add(1, "Java");
        System.out.println(list);
        System.out.println(list.get(2));
        //list.remove(0);
        list.set(0, "Good bye");
        System.out.println(list);

        System.out.println();

        for (String string: list) {
            System.out.println(string);
        }

        System.out.println();

        Iterator<String> iterator = list.iterator();
        for (; iterator.hasNext();) {
            String element = iterator.next();
            if(element.charAt(0) == 'J') {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
