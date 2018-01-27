package main.com.yuliiakulyk.app.e.streams.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 27.01.2018.
 */
public class CommonWordsFromFiles {

    public static File getFileWithCommonWords(File file1, File file2) throws IOException {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        File file = new File(new File("src").getAbsolutePath().replaceAll(new File("src").getName(), "") + "/commonWords.txt");

            String[] words1 = fileToStringBuilder(file1).replaceAll("[():#%\"'.,!?\\\\-]", " ").replaceAll("  ", " ").split(" ");
            String[] words2 = fileToStringBuilder(file2).replaceAll("[():#%\"'.,!?\\\\-]", " ").split(" ");
            List<String> arrayList = new ArrayList<String>();
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

    private static String fileToStringBuilder(File file) throws IOException {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            for (; (str = reader.readLine()) != null; ) {
                builder.append(str);
            }
            return builder.toString();
    }

    public static void fileToConsole(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String string = "";
        System.out.println("File " + file.getAbsolutePath() + " content: ");
        System.out.println("------------------------------------------------------");
        for (; (string = reader.readLine()) != null; ) {
            System.out.println(string);
        }
        reader.close();
        System.out.println("------------------------------------------------------");
    }

    public static void writeArrayToFile(Object[] array, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                writer.write(array[i].toString());
                writer.newLine();
            }
        }
        writer.close();
    }
}
