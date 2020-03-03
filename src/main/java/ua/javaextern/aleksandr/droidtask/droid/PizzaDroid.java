package ua.javaextern.aleksandr.droidtask.droid;

import java.io.Serializable;

import static ua.javaextern.aleksandr.droidtask.mvc_game.DroidsParameters.*;

public class PizzaDroid extends Droid implements Serializable {

    public PizzaDroid(){
        super(PIZZA_DROID_NAME, PIZZA_DROID_ATTACK, PIZZA_DROID_ARMOR,
                PIZZA_DROID_HEALTH, PIZZA_DROID_ATTACK_STRATEGY);
    }

    @Override
    void speak() {
        System.out.println("*pizza theme playing*");
    }

}
