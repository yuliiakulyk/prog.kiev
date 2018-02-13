package main.com.yuliiakulyk.app.h.generics.collections;

import main.com.yuliiakulyk.app.g.object.Cat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Yuliia Kulyk on 13.02.2018.
 */
public class Main4 {
    public static void main(String[] args) {
        Integer[] array = getArray(20);
        System.out.println(Arrays.toString(array));
        printStatistics(array);

        System.out.println(printStatisticsGeneral(array));

        Cat cat = new Cat();
    }

    public static Integer[] getArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public static void printStatistics(Integer[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number: array) {
            Integer temp = map.get(number);
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, temp + 1);
            }
        }
        System.out.println(map);
    }

    public static <T> Map<T, Integer> printStatisticsGeneral(T[] array) {
        Map<T, Integer> map = new HashMap<>();
        for (T object: array) {
            Integer temp = map.get(object);
            if (!map.containsKey(object)) {
                map.put(object, 1);
            } else {
                map.put(object, temp + 1);
            }
        }
        return map;
    }
 }
