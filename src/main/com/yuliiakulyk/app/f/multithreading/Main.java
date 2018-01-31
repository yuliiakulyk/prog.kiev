package main.com.yuliiakulyk.app.f.multithreading;

/**
 * Created by Yuliia Kulyk on 30.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        FactorialTask task1 = new FactorialTask(10);
        FactorialTask task2 = new FactorialTask(10);
        FactorialTask task3 = new FactorialTask(10);

        Thread threadOne = new Thread(task1);
        Thread threadTwo = new Thread(task2);
        Thread threadThree = new Thread(task3);

//        threadOne.setPriority(9);
//        threadTwo.setPriority(5);
//        threadThree.setPriority(1);

//        threadOne.setDaemon(true);
//        threadTwo.setDaemon(true);
//        threadThree.setDaemon(true);

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        threadOne.interrupt();
//        threadTwo.interrupt();
//        threadThree.interrupt();
//
//        try {
//            threadOne.join();
//            threadTwo.join();
//            threadThree.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Thread thr = Thread.currentThread();
        System.out.println(thr.getName() + " stopped!");

        int proc = Runtime.getRuntime().availableProcessors();
        System.out.println("Ядер процессора: " + proc);
    }
}
