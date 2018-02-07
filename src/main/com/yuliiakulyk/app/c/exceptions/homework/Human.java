package main.com.yuliiakulyk.app.c.exceptions.homework;

import java.io.Serializable;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 *
 * Создайте класс описывающий человека (создайте метод
 выводящий информацию о человеке)
 На его основе создайте класс студент (переопределите
 метод вывода информации)
 */
public class Human implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean isMale; //true - male, false - female

    public Human(String name, String surname, int age, String address, boolean isMale) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.isMale = isMale;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return name + ','
                + surname + ","
                + age + ","
                + address + ","
                + isMale;
    }
}
