package main.com.yuliiakulyk.app.g.object.homework;

/**
 * Created by Yuliia Kulyk on 07.02.2018.
 */
public class MainStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);

        for (int i = 0; i < 12; i++) {
            myStack.push(new Integer(i));
        }

        for (int i = 0; i < 12; i++) {
            System.out.println(myStack.pop());
        }
    }
}
