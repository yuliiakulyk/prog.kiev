package main.com.yuliiakulyk.app.h.generics.collections.homework;

import java.io.File;
import java.io.IOException;
import java.util.SortedSet;

/**
 * Created by Yuliia Kulyk on 10.02.2018.
 Считайте из файла текст на английском языке, вычислите
 относительную частоту повторения каждой буквы и выведите на
 экран результат в порядке убывания относительной частоты
 повторения.
 */
public class MainTask3 {
    public static void main(String[] args) {
        try {
            SortedSet<Letter> set = CharRepetitions.sortedLettersFromString(CharRepetitions.stringFromFile(new File("src\\main\\com\\yuliiakulyk\\app\\h\\generics\\collections\\homework\\text.txt")));
            CharRepetitions.printCharacterSet(set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
