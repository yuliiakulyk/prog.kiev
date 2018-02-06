package main.com.yuliiakulyk.app.g.object;

import java.io.Serializable;

/**
 * Created by Yuliia Kulyk on 06.02.2018.
 */
public class Cat implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
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
    protected void finalize() throws Throwable {
        Main.mainCat = this;
        System.out.println(this + "DELETED!");
        super.finalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        if (name != null ? !name.equals(cat.name) : cat.name != null) return false;
        return color != null ? color.equals(cat.color) : cat.color == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public Cat clone() throws CloneNotSupportedException {
        return (Cat) super.clone();
    }
}
