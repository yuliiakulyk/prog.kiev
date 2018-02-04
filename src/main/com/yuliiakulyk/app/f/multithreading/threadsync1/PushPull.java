package main.com.yuliiakulyk.app.f.multithreading.threadsync1;

/**
 * Created by Yuliia Kulyk on 01.02.2018.
 */
public class PushPull implements Runnable {
    private Ac ac;
    private boolean turn;
    private String text;

    public PushPull(Ac ac, boolean turn, String text) {
        this.ac = ac;
        this.turn = turn;
        this.text = text;
    }

    public PushPull() {
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            ac.printText(text, turn);
        }
    }
}
