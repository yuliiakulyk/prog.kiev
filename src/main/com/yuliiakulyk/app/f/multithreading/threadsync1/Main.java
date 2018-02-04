package main.com.yuliiakulyk.app.f.multithreading.threadsync1;

/**
 * Created by Yuliia Kulyk on 01.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        Ac ac = new Ac();

        PushPull push = new PushPull(ac, true, "Push");
        PushPull pull = new PushPull(ac, false, "Pull");

        Thread pushThread = new Thread(push);
        Thread pullThread = new Thread(pull);

        pullThread.start();
        pushThread.start();
    }
}
