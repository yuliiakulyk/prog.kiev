package main.com.yuliiakulyk.app.a.classes;

/**
 * Created by Yuliia Kulyk on 15.01.2018.
 */
public class CatMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("black", 60, "Siam", "Vaska", "Andrey Vasko");
        System.out.println(cat1);
        cat1.setColor("red");
        System.out.println(cat1);

        Cat cat2 = new Cat();
        cat2.setColor("white");
        cat2.setBreed("British");
        cat2.setFurLength(10);
        cat2.setName("Kubik");
        cat2.setLength(70);
        cat2.setOwner("Anton");
        System.out.println(cat2);
    }
}
