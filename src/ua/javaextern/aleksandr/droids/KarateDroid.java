package ua.javaextern.aleksandr.droids;


public class KarateDroid extends Droid{

    public KarateDroid(String name, int attack, int armor, int health, String defPos) {
        super(name, attack, armor, health,defPos);
    }


    /*private int attackValue;
    private int armorValue;
    private int healthValue;


    public KarateDroid(int attack, int armor, int health) {
        attackValue = attack;
        armorValue = armor;
        healthValue = health;
    }
    */

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
