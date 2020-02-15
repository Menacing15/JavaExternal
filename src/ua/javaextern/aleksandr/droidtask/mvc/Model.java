package ua.javaextern.aleksandr.droidtask.mvc;

import ua.javaextern.aleksandr.droidtask.droid.*;

import java.util.Random;
import java.util.Scanner;

import static ua.javaextern.aleksandr.droidtask.mvc.DroidsParameters.*;

public class Model {

    public Droid chooseDroid(Scanner scanner){
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        switch (scanner.nextInt()) {
            case 1:
                return new BatDroid(BAT_DROID_NAME, BAT_DROID_ATTACK,
                        BAT_DROID_ARMOR, BAT_DROID_HEALTH);
            case 2:
                return new PizzaDroid(PIZZA_DROID_NAME,PIZZA_DROID_ATTACK,
                        PIZZA_DROID_ARMOR, PIZZA_DROID_HEALTH);
            default:
                return new KarateDroid(KARATE_DROID_NAME, KARATE_DROID_ATTACK,
                        KARATE_DROID_ARMOR, KARATE_DROID_HEALTH);
        }
    }

    public Droid pickRandomAttackingDroidAndAttack(Droid firstFighter, Droid secondFighter) {
        int fortuitousMotion = new Random().nextInt() % 2;
        if(fortuitousMotion == 0){
            firstFighter.attackMovement(secondFighter);
            return firstFighter;
        }else{
            secondFighter.attackMovement(firstFighter);
            return secondFighter;
        }
    }
}