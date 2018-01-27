package main.com.yuliiakulyk.app.e.streams;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yuliia Kulyk on 25.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        File in = new File("C:\\Users\\123\\Desktop\\Java OOP (All cource).pdf");
        File out = new File(in.getName());

        System.out.println(in.getName());

        try {
            FileWork.fileCopy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
