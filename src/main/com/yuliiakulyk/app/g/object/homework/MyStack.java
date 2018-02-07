package main.com.yuliiakulyk.app.g.object.homework;

/**
 * Created by Yuliia Kulyk on 07.02.2018.
 */
public class MyStack {
    private Object[] objects;
    private int pointer;

    public MyStack(int size) {
        this.objects = new Object[10];
        this.pointer = -1;
    }

    public void push(Object object) {
        if (pointer >= objects.length - 1) {
            System.out.println("Stack is full");
        } else {
            objects[++pointer] = object;
            System.out.println("Added to stack object: " + object + ", pointer at: " + pointer);
        }
    }

    public Object pop() {
        if (pointer >= 0) {
            return objects[pointer--];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
}
