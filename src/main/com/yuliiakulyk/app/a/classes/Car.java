package main.com.yuliiakulyk.app.a.classes;

/**
 * Created by Yuliia Kulyk on 11.01.2018.
 */

class Car {
        private String color;
        private double weight;
        private int year;

    public Car(String color, double weight, int year) {
        this.color = color;
        this.weight = weight;
        this.year = year;
    }

    public Car() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getVelosity() {
        return velosity;
    }


    private double velosity=0;


    public void beep(){
            System.out.println("BEEP-BEEP!!!");
        }
        public void acceleration (
                double a){
            velosity=velosity+a;
        }
        public void deceleration(double b){
            if(velosity-b>=0) velosity=velosity-b;
        }

    @Override
    public String toString() {
        return "main.com.yuliiakulyk.app.a.classes.Car{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", year=" + year +
                ", velosity=" + velosity +
                '}';
    }
}
