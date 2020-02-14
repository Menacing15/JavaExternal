package ua.javaextern.aleksandr.droidtask.droid;

public class BatDroid extends Droid {

    public BatDroid(String name, int attack, int armor, int health) {
        super(name, attack, armor, health);
    }

    @Override
    void move() {
        System.out.println("I'm flying like a bat!");
    }

    @Override
    void work() {
        System.out.println("Bats don't work..");
    }

    @Override
    void speak() {
        System.out.println("*ultrasound*");
    }

}
