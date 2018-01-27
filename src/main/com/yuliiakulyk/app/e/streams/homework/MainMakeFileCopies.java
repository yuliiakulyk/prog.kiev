package main.com.yuliiakulyk.app.e.streams.homework;

import main.com.yuliiakulyk.app.e.streams.FileWork;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Created by Yuliia Kulyk on 27.01.2018.
 */
public class MainMakeFileCopies {
    public static void main(String[] args) {
        DocFileFilter docFileFilter = new DocFileFilter();
        File src = new File("src");
        File projectFolder = new File(src.getAbsolutePath().replace(src.getName(), ""));
        File[] list = projectFolder.listFiles(docFileFilter);
        System.out.println("doc files in project folder");
        File docCopiesFolder = new File(projectFolder.getAbsolutePath() + "/docCopiesFolder");
        docCopiesFolder.mkdirs();
        for (File file: list) {
            System.out.println("doc file path before: " + file.getAbsolutePath());
            File copy = new File(docCopiesFolder.getAbsolutePath() + "/" + file.getName());
            try {
                FileWork.fileCopy(file, copy);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("doc file path after: " + copy.getAbsolutePath());
        }
    }
}
