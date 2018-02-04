package main.com.yuliiakulyk.app.f.multithreading.threadsync2;

/**
 * Created by Yuliia Kulyk on 01.02.2018.
 */
public class Helper {
    private String process;

    public Helper() {
    }

    public synchronized void setProcess(String process) {
        for (; process.equalsIgnoreCase(this.process);) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.process = process;
        System.out.println(process);
        notifyAll();
    }
}
