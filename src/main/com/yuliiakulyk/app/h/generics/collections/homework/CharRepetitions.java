package main.com.yuliiakulyk.app.h.generics.collections.homework;

import java.io.*;
import java.util.*;

/**
 * Created by Yuliia Kulyk on 10.02.2018.
 Считайте из файла текст на английском языке, вычислите
 относительную частоту повторения каждой буквы и выведите на
 экран результат в порядке убывания относительной частоты
 повторения.
 */
public class CharRepetitions {
    public static String stringFromFile(File file) throws IOException {
        StringBuilder builder = new StringBuilder("");
        String str;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (; (str = reader.readLine()) != null;) {
                builder.append(str);
                builder.append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
        return builder.toString();
    }

    public static SortedSet<Letter> sortedLettersFromString(String string) {
        SortedSet<Letter> set = new TreeSet<>();
        List<Letter> list = new ArrayList<>();
        Letter currentLetter;
        for (int i = 0; i < string.length(); i++) {
            currentLetter = new Letter(string.charAt(i), string.length());
            if (list.contains(currentLetter)) {
                list.set(list.indexOf(currentLetter), list.get(list.indexOf(currentLetter)).increaseRepetitionsBy1());
            } else {
                list.add(currentLetter);
            }
        }
        set.addAll(list);
        return set;
    }

    public static void printCharacterSet(SortedSet<Letter> set) {
        for (Letter letter: set) {
            System.out.println(letter);
        }
    }
}
