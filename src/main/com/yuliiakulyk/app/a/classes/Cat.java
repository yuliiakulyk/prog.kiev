package main.com.yuliiakulyk.app.a.classes;

/**
 * Created by Yuliia Kulyk on 15.01.2018.
 */
public class Cat {
    private String color;
    private int length;
    private String breed;
    private int furLength;
    private String name;
    private String owner;

    public Cat(String color, int length, String breed, int furLength, String name, String owner) {
        this.color = color;
        this.length = length;
        this.breed = breed;
        this.furLength = furLength;
        this.name = name;
        this.owner = owner;
    }

    public Cat(String color, int length, String breed, String name, String owner) {
        this.color = color;
        this.length = length;
        this.breed = breed;
        this.name = name;
        this.owner = owner;
    }

    public Cat(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public Cat() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getFurLength() {
        return furLength;
    }

    public void setFurLength(int furLength) {
        this.furLength = furLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void meow() {
        System.out.println("Meow!!!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", length=" + length +
                ", breed='" + breed + '\'' +
                ", furLength=" + furLength +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}