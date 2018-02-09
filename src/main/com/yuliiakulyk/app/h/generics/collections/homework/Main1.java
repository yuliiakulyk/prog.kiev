package main.com.yuliiakulyk.app.h.generics.collections.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 09.02.2018.
 Написать метод, который создаст список, положит в него 10
 элементов, затем удалит первые два и последний, а затем выведет
 результат на экран.
 */
public class Main1 {
    public static void main(String[] args) {
        method();
    }

    public static <T extends Number> void method() {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((T) new Integer((i + 1) * (i + 1)));
        }
        System.out.println(list);
        list.remove(0);
        list.remove(0);
        list.remove(list.size() - 1);
        System.out.println(list);
    }

}
