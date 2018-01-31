package main.com.yuliiakulyk.app.f.multithreading.homework;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Yuliia Kulyk on 31.01.2018.
 */
public class ArraySumTask implements Runnable {
    private BigInteger sum;
    private int[] arrayToSum;

    public ArraySumTask(int[] arrayToSum) {
        this.arrayToSum = arrayToSum;
    }

    public ArraySumTask() {
        this.arrayToSum = generateIntArray(1000, 100);
    }

    public BigInteger getSum() {
        return sum;
    }

    public int[] getArrayToSum() {
        return arrayToSum;
    }

    public void setArrayToSum(int[] arrayToSum) {
        this.arrayToSum = arrayToSum;
    }

    public static int[] generateIntArray(int length, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumber(0, maxValue);
        }
        return array;
    }

    public static int generateNumber(int min, int max) {
        if (max < min) {
            int i = max;
            max = min;
            min = i;
        }
        return new Random().nextInt((max - min) + 1) + min;
    }

    public void calculateIntArraySum() {
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < this.arrayToSum.length; i++) {
            sum = sum.add(new BigInteger("" + arrayToSum[i]));
        }
        this.sum = sum;
        //System.out.println("array length: " + this.arrayToSum.length);
        //System.out.println("Calculated sum = " + sum);
    }

    @Override
    public void run() {
        Thread thr = Thread.currentThread();
        calculateIntArraySum();
        System.out.println(thr.getName() + " finished!");
    }
}
