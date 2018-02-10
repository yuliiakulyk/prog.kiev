package main.com.yuliiakulyk.app.g.object.homework;

import java.util.Arrays;

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
 списка, то добавление такого объекта запрещено.

 Для описанного выше стека создайте класс «Черный список» в котором
 будут описаны классы объектов которые нельзя добавлять в стек.
 Должна быть возможность добавления классов в черный список, проверка
 объекта — на то что класс к которому он принадлежит принадлежит или
 не принадлежит к классам в черном списке.
 */
public class MyStack {
    private Object[] objects;
    private int pointer;
    private Blacklist blacklist;

    public MyStack(int size, Blacklist blacklist) {
        this.objects = new Object[size];
        this.pointer = -1;
        this.blacklist = blacklist;
    }

    public void push(Object object) throws StackOverflowError, IllegalArgumentException {
        if (pointer >= objects.length - 1) {
            throw new StackOverflowError();
        } else if (blacklist.isAllowed(object)) {
            objects[++pointer] = object;
            System.out.println("Added to stack object: " + object.getClass().getName() + ", pointer at: " + pointer);
        } else {
            throw new IllegalArgumentException("Class " + object.getClass().getName() + " is blacklisted");
        }
    }

    public Object pop() {
        if (pointer >= 0) {
            return objects[pointer--];
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String[] objectClasses = new String[pointer];
        for (int i = 0; i < pointer; i++) {
            objectClasses[i] = objects[i].getClass().getSimpleName();
        }
        return "MyStack{" +
                "objects=" + Arrays.toString(objectClasses) +
                '}';
    }
}
