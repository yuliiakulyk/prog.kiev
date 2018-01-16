package main.com.yuliiakulyk.app.b.inheritance;

/**
 * Created by Yuliia Kulyk on 16.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        Cat catOne = new Cat(3, 5, true, "Milk", "Vaska", "Siam");
        System.out.println(catOne.getAge());
        System.out.println(catOne.hashCode());
        catOne.getVoice();
        System.out.println(catOne.toString());
        Animal animal = catOne;
        animal.getVoice();
        Animal[] zooArray = new Animal[10];
        zooArray[0] = catOne;
        for (Animal a : zooArray) {
            System.out.println(a);
        }

        Cat catTwo = (Cat) zooArray[0];
        System.out.println(catTwo.toString());
    }
}
