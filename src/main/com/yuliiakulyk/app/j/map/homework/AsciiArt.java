package main.com.yuliiakulyk.app.j.map.homework;

import java.io.*;
import java.util.*;

/**
 * Created by Yuliia Kulyk on 18.02.2018.
 */
public class AsciiArt {
    private Map<Character, String[]> font;
    private int lettersHeight;

    public AsciiArt(Map <Character, String[]> font, int lettersHeight) {
        this.font = font;
        this.lettersHeight = lettersHeight;
    }

    public Map<Character, String[]> getFont() {
        return font;
    }

    public static Map<Character, String[]> fileToMap(File file, int lettersHeight) throws IOException {
        Map<Character, String[]> map = new HashMap<>();
        String temp;
        Character character;
        String[] letterArray;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while((temp = reader.readLine()) != null) {
                character = temp.charAt(0);
                letterArray = new String[lettersHeight];
                for (int i = 0; i < lettersHeight; i++) {
                    temp = reader.readLine();
                    letterArray[i] = temp;
                }
                map.put(character, letterArray);
            }
        }
        return map;
    }

    public String stringToAsciiArt(String string) {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < this.lettersHeight; i++) {
            for (int j = 0; j < string.length(); j++) {
                if (this.font.containsKey(string.charAt(j))) {
                    builder.append(this.font.get(string.charAt(j))[i]);
                }
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

}
