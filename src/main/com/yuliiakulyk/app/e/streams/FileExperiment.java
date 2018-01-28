package main.com.yuliiakulyk.app.e.streams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Yuliia Kulyk on 26.01.2018.
 */
public class FileExperiment {
    public static void main(String[] args) {
        File nonExistingFile = new File("someFile.txt");
        File existingFile = new File("Java OOP (All cource).pdf");
        File directory = new File("C:\\Users\\123\\Documents\\prog.kiev");

        System.out.println("Abs path to non-existing file: " + nonExistingFile.getAbsolutePath());

        System.out.println("getName: " + nonExistingFile.getName());
        try {
            System.out.println("getCanonical path: " + nonExistingFile.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("canRead(): " + nonExistingFile.canRead());
        System.out.println("canWrite(): " + nonExistingFile.canWrite());
        System.out.println("exists(): " + nonExistingFile.exists());
        System.out.println("isDirectory(): " + nonExistingFile.isDirectory());
        System.out.println("isFile(): " + nonExistingFile.isFile());
        System.out.println("length(): " + nonExistingFile.length());
        System.out.println("compareTo(existingFile): " + nonExistingFile.compareTo(existingFile));
        System.out.println("getParent(): " + nonExistingFile.getParent());
        System.out.println("getAbsoluteFile(): " + nonExistingFile.getAbsoluteFile());
        System.out.println("getFreeSpace(): " + nonExistingFile.getFreeSpace());


        System.out.println();
        System.out.println("existing file length:" + existingFile.length());
        System.out.println("canRead(): " + existingFile.canRead());
        System.out.println("canWrite(): " + existingFile.canWrite());
        System.out.println("isDirectory(): " + existingFile.isDirectory());
        System.out.println("isFile(): " + existingFile.isFile());
        System.out.println("getParent(): " + existingFile.getParent());
        System.out.println("getFreeSpace(): " + existingFile.getFreeSpace());

        System.out.println();
        System.out.println("getParent() for directory: " + directory.getParent());
        System.out.println();

        File[] filesInProgKiev = directory.listFiles();
        System.out.println("Files in directory " + directory.getPath());
        for (File file:filesInProgKiev
             ) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println();
        File folder = new File("F");
        folder.mkdirs();
        folder.delete();

        File file4 = new File("/");
        System.out.println(file4.exists());
        System.out.println(file4.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        File file3 = new File(System.getProperty("user.dir"), "fileInProjectFolder.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file3));
            writer.write("Hello world!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}