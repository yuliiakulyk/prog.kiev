package main.com.yuliiakulyk.app.e.streams;

import java.io.*;

/**
 * Created by Yuliia Kulyk on 25.01.2018.
 */
public class FileWork {

    public static void fileCopy(File in, File out) throws IOException {
        if (in == null || out == null) {
            throw new IllegalArgumentException("Null File pointer");
        }
        try(OutputStream os = new FileOutputStream(out);
                InputStream is = new FileInputStream(in)) {
            byte [] buffer = new byte [1024 * 1024];
            int readByte;
            for (; (readByte = is.read(buffer)) > 0;) {
                os.write(buffer, 0, readByte);
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
