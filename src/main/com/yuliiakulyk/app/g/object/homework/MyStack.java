package main.com.yuliiakulyk.app.g.object.homework;

/**
 * Created by Yuliia Kulyk on 07.02.2018.
 *
 * Создайте класс контейнер - стек (класс в который можно добавлять и
 удалять объекты других классов, только в вершину стека) в который
 можно сохранять объекты произвольного типа. Должен быть метод
 добавления элемента в стек,получение с удалением элемента из стека, и
 просто получение элемента из вершины из стека. Должна быть
 реализована работа с «черным списком» классов (смотри ниже). Если
 объект который добавляется в стек принадлежит классу из черного
 списка, то добавление такого объекта запрещено
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
