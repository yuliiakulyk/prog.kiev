package main.com.yuliiakulyk.app.b.inheritance;

/**
 * Created by Yuliia Kulyk on 16.01.2018.
 */
public class Cat extends Animal {
    private String name;
    private String type;

    public Cat(int age, double weigt, boolean sex, String ration, String name, String type) {
        super(age, weigt, sex, ration);
        this.name = name;
        this.type = type;
    }

    @Override
    public void getVoice() {
        System.out.println("Meow!!!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                super.toString() + "}";
    }
}
