package ua.javaextern.aleksandr.droidtask.droid;

public class KarateDroid extends Droid{

    public KarateDroid(String name, int attack, int armor, int health) {
        super(name, attack, armor, health);
    }
    @Override
    void move() {
        System.out.println("Running using my mechanical legs");
    }

    @Override
    void work() {
        System.out.println("kiaaaaa!!!!!");
    }

    @Override
    void speak() {
        System.out.println("im cooler than kung fury");
    }

}
