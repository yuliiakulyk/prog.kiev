package main.com.yuliiakulyk.app.h.generics.collections;

/**
 * Created by Yuliia Kulyk on 08.02.2018.
 */
public class Main2 {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {1, 3, null, 5, -1, 7};
        Integer minOne = getMin(array);
        System.out.println(minOne);

        Character [] array2 = new Character[] {'C', ',', '+', '!'};
        Character minCharacter = getMin(array2);
        System.out.println(minCharacter);
    }

    public static <T extends Comparable<T>> T getMin(T[] array) {
        T min = array[0];
        for (T element: array) {
            if (element == null) continue;
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
}
