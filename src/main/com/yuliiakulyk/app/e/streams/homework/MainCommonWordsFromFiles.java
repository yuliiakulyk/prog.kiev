package main.com.yuliiakulyk.app.e.streams.homework;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yuliia Kulyk on 27.01.2018.
 */
public class MainCommonWordsFromFiles {
    public static void main(String[] args) {
        File file = CommonWordsFromFiles.getFileWithCommonWords(new File("text1.txt"), new File("text2.txt"));
        try {
            CommonWordsFromFiles.fileToConsole(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
