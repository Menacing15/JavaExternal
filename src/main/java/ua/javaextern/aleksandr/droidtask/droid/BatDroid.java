package ua.javaextern.aleksandr.droidtask.droid;

import static ua.javaextern.aleksandr.droidtask.mvc_game.DroidsParameters.*;

public class BatDroid extends Droid {

    public BatDroid(){
        super(BAT_DROID_NAME, BAT_DROID_ATTACK, BAT_DROID_ARMOR,
                BAT_DROID_HEALTH, BAT_DROID_ATTACK_STRATEGY);
    }

    @Override
    void speak() {
        System.out.println("*ultrasound*");
    }

}
