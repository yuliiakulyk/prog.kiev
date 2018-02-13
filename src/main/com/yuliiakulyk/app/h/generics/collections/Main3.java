package main.com.yuliiakulyk.app.h.generics.collections;

import java.util.*;

/**
 * Created by Yuliia Kulyk on 13.02.2018.
 */
public class Main3 {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "one");
        myMap.put(5, "five");
        myMap.put(7, "seven");

        System.out.println(myMap);

        String result = myMap.get(7);
        System.out.println(result);

        String text = myMap.put(1, "One");
        System.out.println(text);

        myMap.remove(3);
        System.out.println(1);

        Set<Integer> keys = myMap.keySet();
        for (Integer key: keys) {
            System.out.println(key + " " + myMap.get(key));
        }

        Map<List<Integer>, String> map2 = new HashMap<>();
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(5);
        map2.put(myList, "My best list");
        System.out.println(map2.get(myList));

        myList.add(2);
        System.out.println(map2.get(myList));
    }
}
