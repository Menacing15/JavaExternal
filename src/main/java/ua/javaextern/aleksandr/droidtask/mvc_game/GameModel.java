package ua.javaextern.aleksandr.droidtask.mvc_game;

import ua.javaextern.aleksandr.droidtask.droid.*;

import java.util.Random;
import java.util.Scanner;

import static ua.javaextern.aleksandr.droidtask.mvc_game.DroidsParameters.*;

public class GameModel {

    Droid chooseDroid(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        switch (scanner.nextInt()) {
            case 1:
                return new BatDroid();
            case 2:
                return new PizzaDroid();
            default:
                return new KarateDroid();
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
