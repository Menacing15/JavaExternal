package ua.javaextern.aleksandr.droidtask.droid;

import ua.javaextern.aleksandr.droidtask.strategy.SimpleAttackStrategy;

public class BatDroid extends Droid {

    public BatDroid(){

    }

    public BatDroid(String name, int attack, int armor, int health) {
        super(name, attack, armor, health,new SimpleAttackStrategy());
    }

    @Override
    void speak() {
        System.out.println("*ultrasound*");
    }

}
