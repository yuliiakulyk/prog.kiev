package main.com.yuliiakulyk.app.f.multithreading.threadsync1;

/**
 * Created by Yuliia Kulyk on 01.02.2018.
 */
public class Ac {
    boolean turn = true;

    public Ac() {
    }

    public synchronized void printText(String text, boolean turn) {
        for (; this.turn != turn ; ) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(text + " ");
        this.turn = !this.turn;
        notifyAll();
    }

}
