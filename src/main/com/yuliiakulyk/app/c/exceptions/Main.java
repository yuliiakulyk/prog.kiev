package main.com.yuliiakulyk.app.c.exceptions;

/**
 * Created by Yuliia Kulyk on 18.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Main.div(5, 0));
    }

    /**
     * <B>return div a / b</B>
     * @param a - int value
     * @param b - int value
     * @return int value a div b
     */
    static int div(int a, int b) {
        int c;
        try {
            c = a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            c = Integer.MAX_VALUE;
        } finally {
            return 10;
        }
    }
}
