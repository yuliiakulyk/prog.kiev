package main.com.yuliiakulyk.app.f.multithreading.homework;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Yuliia Kulyk on 31.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        int length = 10000000;
        int[] array1 = ArraySumTask.generateIntArray(length, 1000);
        //System.out.println(Arrays.toString(array1));
        int quarter1 = (int) length / 4;
        int quarter2 = (int) length / 2;
        int quarter3 = (int) length / 4 * 3;
        
        ArraySumTask taskSingleThread = new ArraySumTask(array1);
        ArraySumTask taskThread1 = new ArraySumTask(Arrays.copyOfRange(array1, 0, quarter1));
        ArraySumTask taskThread2 = new ArraySumTask(Arrays.copyOfRange(array1, quarter1, quarter2));
        ArraySumTask taskThread3 = new ArraySumTask(Arrays.copyOfRange(array1, quarter2, quarter3));
        ArraySumTask taskThread4 = new ArraySumTask(Arrays.copyOfRange(array1, quarter3, length));
        Thread thread1 = new Thread(taskThread1);
        Thread thread2 = new Thread(taskThread2);
        Thread thread3 = new Thread(taskThread3);
        Thread thread4 = new Thread(taskThread4);

        long timeBefore1 = System.currentTimeMillis();
        System.out.println ("Time before calculating sum in 1 thread: " + timeBefore1);
        taskSingleThread.calculateIntArraySum();
        System.out.println("sum = " + taskSingleThread.getSum());
        long timeAfter1 = System.currentTimeMillis();
        System.out.println("Time after calculating sum in 1 thread: " + timeAfter1);
        long timeTaken1 = timeAfter1 - timeBefore1;
        System.out.println("Time taken for calc in milllis: " + timeTaken1);

        long timeBefore2 = System.currentTimeMillis();
        System.out.println ("Time before calculating sum in 4 threads: " + timeBefore2);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BigInteger sumFinal = new BigInteger("0");
        sumFinal = sumFinal.add(taskThread1.getSum());
        sumFinal = sumFinal.add(taskThread2.getSum());
        sumFinal = sumFinal.add(taskThread3.getSum());
        sumFinal = sumFinal.add(taskThread4.getSum());
        System.out.println("Sum = " + sumFinal);

        long timeAfter2 = System.currentTimeMillis();
        System.out.println("Time after calculating sum in 4 threads: " + timeAfter2);
        long timeTaken2 = timeAfter2 - timeBefore2;
        System.out.println("Time taken by 4 threads: " + timeTaken2);
        double times = (double) timeTaken1 / (double) timeTaken2;
        System.out.println("Time taken by 1 thread is " + times + " times more than by 4 threads.");
    }
}
