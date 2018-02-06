package main.com.yuliiakulyk.app.g.object;

import java.io.*;

/**
 * Created by Yuliia Kulyk on 06.02.2018.
 */
public class ObjectFileWorker {

    public static void saveObjectToFile(File file, Object obj) throws IOException {
        if (file == null || obj == null) {
            throw new IllegalArgumentException();
        }
        try (ObjectOutput oos = new ObjectOutputStream(
                new FileOutputStream(file))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            throw e;
        }
    }

    public static Object loadObjectFromFile(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException();
        }
        Object result = null;
        try (ObjectInput ois = new ObjectInputStream(new FileInputStream(file))) {
            result = ois.readObject();
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}