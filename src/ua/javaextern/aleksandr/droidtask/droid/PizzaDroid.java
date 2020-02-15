package ua.javaextern.aleksandr.droidtask.droid;

public class PizzaDroid extends Droid{

    public PizzaDroid(String name,int attack, int armor, int health) {
        super(name, attack, armor, health);
    }

    @Override
    void move() {
        System.out.println("Using my small wheels...");
    }

    @Override
    void work() {
        System.out.println("Making pizza...");
    }

    @Override
    void speak() {
        System.out.println("*pizza theme playing*");
    }

}
