package main.com.yuliiakulyk.app.j.map.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuliia Kulyk on 17.02.2018.
 */
public class Dictionary {
    private Map<String, String> words;

    public Dictionary(File file) {
        try {
            this.words = listToMap(fileToListString(file));
        } catch (IOException e) {
            e.printStackTrace();
            this.words = new HashMap<>();
        }
    }

    public Dictionary() {
        this.words = new HashMap<>();
    }

    public Map<String, String> getWords() {
        return words;
    }

    public static List<String> fileToListString(File file) throws IOException {
        List<String> linesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Unicode"))) {
            String temp;
            for (; (temp = reader.readLine()) != null;) {
                linesList.add(temp);
            }
        }
        return linesList;
    }

    public static void listStringToFile(List<String> list, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "Unicode"))) {
            for (String string: list) {
                writer.write(string);
                writer.write(System.lineSeparator());
            }
        }
    }

    public static Map<String, String> listToMap(List<String> list) {
        Map<String, String> map = new HashMap<>();
        for (String line:list) {
            map.put(line.split(",")[0].trim(), line.split(",")[1].trim());
        }
        return map;
    }

    public void addWords(String inEnglish, String inUkrainian, File file) throws IOException {
        this.words.put(inEnglish, inUkrainian);
        Dictionary.addToFile(inEnglish + ", " + inUkrainian, file);
    }

    public static void addToFile(String line, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "Unicode"))) {
                writer.write(line);
                writer.write(System.lineSeparator());
        }
    }

    public void translateFile(File in, File out) throws IOException {
        List<String> linesIn = fileToListString(in);
        List<String> resultList = translateListString(linesIn);
        listStringToFile(resultList, out);
    }

    public String translateString(String inEnglish) {
        String[] wordsInEnglish = inEnglish.split(" ");
        String temp;
        String result = inEnglish;
        for (int i = 0; i < wordsInEnglish.length; i++) {
            temp = wordsInEnglish[i].replaceAll("[^a-zA-Z ]", "");
            if (this.words.containsKey(temp)) {
                result = result.replace(temp, this.words.get(temp));
            }
        }
        return result;
    }

    public List<String> translateListString(List<String> inEnglish) {
        List<String> result = new ArrayList<>();
        for (String string: inEnglish) {
            result.add(this.translateString(string));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "words=" + words +
                '}';
    }
}
