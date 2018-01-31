package main.com.yuliiakulyk.app.f.multithreading;

import java.math.BigInteger;

/**
 * Created by Yuliia Kulyk on 30.01.2018.
 */
public class FactorialTask implements Runnable {
    private int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    public FactorialTask() {
        this.number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private BigInteger calculateFactorial(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n ; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thr = Thread.currentThread();
        for (int i = 1; i <= number; i++) {
            System.out.println(thr.getName() + " -> " + i + "! = " + calculateFactorial(i));
            if (thr.isInterrupted()) {
                System.out.println("Thread is interrupted: " + thr.getName());
                break;
            }
        }
        System.out.println(thr.getName() + " stopped!");
    }
}
