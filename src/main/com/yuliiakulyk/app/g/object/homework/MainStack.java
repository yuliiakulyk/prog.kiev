package main.com.yuliiakulyk.app.g.object.homework;

import main.com.yuliiakulyk.app.a.classes.Cat;

import java.util.Scanner;

/**
 * Created by Yuliia Kulyk on 07.02.2018.
 */
public class MainStack {
    public static void main(String[] args) {
        Blacklist blacklist = new Blacklist();
        blacklist.addClass(Integer.class);
        blacklist.addClass(Double.class);

        MyStack myStack = new MyStack(10, blacklist);

        myStack.push(new Boolean(true));
        try {
            myStack.push(new Integer(12));
        } catch (Exception e) {
            e.printStackTrace();
        }
        myStack.push("String");
        myStack.push(new Scanner(System.in));
        myStack.push(new Cat());


        System.out.println(myStack);


        for (int i = 0; i < 6; i++) {
            System.out.println(myStack.pop());
        }
    }
}
