package main.com.yuliiakulyk.app.f.multithreading.threadsync2;

/**
 * Created by Yuliia Kulyk on 01.02.2018.
 */
public class Main1 {
    public static void main(String[] args) {
        Helper helper = new Helper();
        PushPull push = new PushPull("Push", helper);
        PushPull pull = new PushPull("Pull", helper);

        Thread th1 = new Thread(push);
        Thread th2 = new Thread(pull);

        th1.start();
        th2.start();
    }
}
