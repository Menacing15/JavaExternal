package ua.javaextern.aleksandr.droidtask.droid;

import java.io.Serializable;

import static ua.javaextern.aleksandr.droidtask.mvc_game.DroidsParameters.*;

public class KarateDroid extends Droid implements Serializable {

    public KarateDroid(){
        super(KARATE_DROID_NAME, KARATE_DROID_ATTACK, KARATE_DROID_ARMOR,
                KARATE_DROID_HEALTH, KARATE_DROID_ATTACK_STRATEGY);
    }

    @Override
    void speak() {
        System.out.println("im cooler than kung fury");
    }

}
