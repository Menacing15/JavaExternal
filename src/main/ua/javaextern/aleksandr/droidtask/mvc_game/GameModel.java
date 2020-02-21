package main.ua.javaextern.aleksandr.droidtask.mvc_game;

import main.ua.javaextern.aleksandr.droidtask.droid.*;

import java.util.Random;
import java.util.Scanner;

import static main.ua.javaextern.aleksandr.droidtask.mvc_game.DroidsParameters.*;

public class GameModel {

    Droid chooseDroid(){
        Scanner scanner = new Scanner(System.in);
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

    Droid getRandomAttackingDroid(Droid firstFighter, Droid secondFighter) {
        int fortuitousMotion = new Random().nextInt() % 2;
        if(fortuitousMotion == 0){
            return firstFighter;
        }else{
            return secondFighter;
        }
    }

    Droid getDefendingDroid(Droid attackingDroid, Droid firstFighter, Droid secondFighter) {
        if(attackingDroid.equals(firstFighter)){
            return secondFighter;
        }else{
            return firstFighter;
        }
    }

    Droid getWinnerDroid(Droid firstFighter, Droid secondFighter){
        if(firstFighter.getHealthValue() > 0){
            return firstFighter;
        }else{
            return secondFighter;
        }
    }
}