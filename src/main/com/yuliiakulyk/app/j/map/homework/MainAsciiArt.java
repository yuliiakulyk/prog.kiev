package main.com.yuliiakulyk.app.j.map.homework;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Yuliia Kulyk on 18.02.2018.
 */
public class MainAsciiArt {
    public static void main(String[] args) {
        try {
            Map<Character, String[]> map = AsciiArt.fileToMap(new File("src/main/com/yuliiakulyk/app/j/map/homework/asciiArt.txt"), 6);
            AsciiArt asciiArt = new AsciiArt(map, 6);
            System.out.println(asciiArt.stringToAsciiArt("hello world"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
