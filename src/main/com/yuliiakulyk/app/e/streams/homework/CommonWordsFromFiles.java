package main.com.yuliiakulyk.app.e.streams.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 27.01.2018.
 *
 * Напишите программу которая примет на вход 2 текстовых
 файла, а вернет один. Содержимым этого файла должны
 быть слова которые есть и в первом и во втором файле.
 */
public class CommonWordsFromFiles {
    /**
     *
     * @param file1
     * @param file2
     * @return
     * @throws IOException
     */
    public static File getFileWithCommonWords(File file1, File file2) throws IOException {
        if (file1 == null || file2 == null) {
            throw new IllegalArgumentException("Pointer to file is null!");
        }

        File file = new File(System.getProperty("user.dir"), "commonWords.txt");

        String[] words1 = fileToString(file1).replaceAll("[():#%\"'.,!?\\\\-]", " ").replaceAll("  ", " ").split(" ");
        String[] words2 = fileToString(file2).replaceAll("[():#%\"'.,!?\\\\-]", " ").split(" ");
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < words1.length; i++) {
            for (int j = 0; j < words2.length; j++) {
                if (words1[i].equalsIgnoreCase(words2[j]) && !arrayList.contains(words1[i])) {
                    arrayList.add(words1[i]);
                }
            }
        }
        writeArrayToFile(arrayList.toArray(), file);
        return file;
    }

    private static String fileToString(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Pointer to file is null!");
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            for (; (str = reader.readLine()) != null; ) {
                builder.append(str);
            }
        } catch (IOException e) {
            throw e;
        }
        return builder.toString();
    }

    public static void fileToConsole(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Pointer to file is null!");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String string;
            System.out.println("File " + file.getAbsolutePath() + " content: ");
            System.out.println("------------------------------------------------------");
            for (; (string = reader.readLine()) != null; ) {
                System.out.println(string);
            }
            System.out.println("------------------------------------------------------");
        } catch (IOException e) {
            throw e;
        }
    }

    public static void writeArrayToFile(Object[] array, File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Pointer to file is null!");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    writer.write(array[i].toString());
                    writer.newLine();
                }
            }
        }
    }
}
