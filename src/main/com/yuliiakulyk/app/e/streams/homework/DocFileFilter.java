package main.com.yuliiakulyk.app.e.streams.homework;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Yuliia Kulyk on 27.01.2018.
 */
public class DocFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        int dotIndex = pathname.getName().lastIndexOf(".");
        String extension = pathname.getName().substring(dotIndex + 1);
        if (extension.equalsIgnoreCase("doc")) {
            return true;
        }
        return false;
    }
}
