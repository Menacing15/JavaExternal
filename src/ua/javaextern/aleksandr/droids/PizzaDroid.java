package ua.javaextern.aleksandr.droids;

public class PizzaDroid extends Droid{

    public PizzaDroid(String name,int attack, int armor, int health, String defPos) {
        super(name, attack, armor, health,defPos);
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
