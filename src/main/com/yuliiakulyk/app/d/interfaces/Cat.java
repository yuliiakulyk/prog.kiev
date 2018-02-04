package main.com.yuliiakulyk.app.d.interfaces;

/**
 * Created by Yuliia Kulyk on 03.02.2018.
 */
public class Cat implements Comparable {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Cat anotherCat = (Cat) o;
        if (this.age > anotherCat.getAge()) {
            return 1;
        }
        if (this.age < anotherCat.getAge()) {
            return -1;
        }
        return 0;
    }
}
