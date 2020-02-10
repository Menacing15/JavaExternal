package ua.javaextern.aleksandr.droids;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is bot war! Rules are simple, create a droid and attack another droid.\n" +
                "There are 3 parts to attack: head, chest, legs.\n" +
                "Fight to the death!\n");

        BatDroid batDroid = new BatDroid("BatDroid",300,50,100,"head");
        KarateDroid karateDroid = new KarateDroid("KarateDroid", 100,100,200,"head");
        PizzaDroid pizzaDroid = new PizzaDroid("PizzaDroid", 10,750,750,"head");

        batDroid.defend("chest");
        pizzaDroid.attack(batDroid,"chest");

        batDroid.defend("head");
        pizzaDroid.attack(batDroid,"legs");

        batDroid.powerup();
    }
}
