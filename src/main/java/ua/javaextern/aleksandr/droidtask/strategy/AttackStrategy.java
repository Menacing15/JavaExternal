package ua.javaextern.aleksandr.droidtask.strategy;

import ua.javaextern.aleksandr.droidtask.droid.Droid;

import java.io.Serializable;

public interface AttackStrategy extends Serializable {
     void attack(Droid droid, int attackValue);
}
