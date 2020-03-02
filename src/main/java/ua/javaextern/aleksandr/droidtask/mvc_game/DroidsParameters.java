package ua.javaextern.aleksandr.droidtask.mvc_game;

import ua.javaextern.aleksandr.droidtask.strategy.AttackStrategy;
import ua.javaextern.aleksandr.droidtask.strategy.SimpleAttackStrategy;

public interface DroidsParameters {
    String BAT_DROID_NAME = "Bat Droid";
    int BAT_DROID_ATTACK = 300;
    int BAT_DROID_ARMOR = 100;
    int BAT_DROID_HEALTH = 100;
    AttackStrategy BAT_DROID_ATTACK_STRATEGY = new SimpleAttackStrategy();

    String KARATE_DROID_NAME = "Karate Droid";
    int KARATE_DROID_ATTACK = 200;
    int KARATE_DROID_ARMOR = 100;
    int KARATE_DROID_HEALTH = 200;
    AttackStrategy KARATE_DROID_ATTACK_STRATEGY = new SimpleAttackStrategy();

    String PIZZA_DROID_NAME = "Pizza Droid";
    int PIZZA_DROID_ATTACK = 100;
    int PIZZA_DROID_ARMOR = 300;
    int PIZZA_DROID_HEALTH = 100;
    AttackStrategy PIZZA_DROID_ATTACK_STRATEGY = new SimpleAttackStrategy();
}
