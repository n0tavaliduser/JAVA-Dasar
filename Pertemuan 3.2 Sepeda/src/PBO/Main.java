package PBO;

class Bicycle {
    int speed = 0, gear = 0;

    void changeGear(int newValue) {
        gear = gear + newValue;
        System.out.println("\nGear : " + gear);
    }
    void speedUp(int increment) {
        speed = speed + increment;
        System.out.println("\nSpeed : " + speed);
    }
}
public class Main {

    public static void main(String[] args) {
        Bicycle bike = new Bicycle();

        bike.speed = 10;
        bike.gear = 2;

        bike.speedUp(10);
        bike.changeGear(2);
    }
}