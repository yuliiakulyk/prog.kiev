package main.com.yuliiakulyk.app.j.map.homework;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yuliia Kulyk on 17.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        File dictionaryFile = new File("src/main/com/yuliiakulyk/app/j/map/homework/dictionary.txt");
        Dictionary dictionary = new Dictionary(dictionaryFile);
        System.out.println(dictionary);
        //System.out.println(dictionary.translateString("hello magic world!"));
        File fileIn = new File("src/main/com/yuliiakulyk/app/j/map/homework/English.in.txt");
        File fileOut = new File("src/main/com/yuliiakulyk/app/j/map/homework/Ukrainian.out.txt");
        try {
            dictionary.addWords("head", "голова", dictionaryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dictionary.translateFile(fileIn, fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
