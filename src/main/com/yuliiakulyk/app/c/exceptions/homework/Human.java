package main.com.yuliiakulyk.app.c.exceptions.homework;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 */
public class Human {
    private String name;
    private int age;
    private String address;
    private boolean isMale; //true - male, false - female

    public Human(String name, int age, String address, boolean isMale) {
        this.name = name;
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
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", isMale=" + isMale +
                '}';
    }
}
