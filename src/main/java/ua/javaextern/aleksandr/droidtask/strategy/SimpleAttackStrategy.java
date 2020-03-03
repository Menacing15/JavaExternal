package ua.javaextern.aleksandr.droidtask.strategy;
import ua.javaextern.aleksandr.droidtask.droid.Droid;

import java.io.Serializable;

public class SimpleAttackStrategy implements AttackStrategy, Serializable {

    @Override
    public void attack(Droid droid, int attackValue) {
        if (droid.getArmorValue() > 0) {
            droid.setArmorValue(droid.getArmorValue() - attackValue / 2);
        } else {
            droid.setHealthValue(droid.getHealthValue() - attackValue);
        }
    }
}
