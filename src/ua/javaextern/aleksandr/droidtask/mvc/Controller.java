package ua.javaextern.aleksandr.droidtask.mvc;

import ua.javaextern.aleksandr.droidtask.droid.Droid;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startDroidBattle(){
        Scanner scanner = new Scanner(System.in);

        view.printGreetings();
        view.printDroidList();

        Droid firstFighter = model.chooseDroid(scanner);
        view.printSecondNumberRequest();
        Droid secondFighter = model.chooseDroid(scanner);

        view.printChosenDroidNames(firstFighter,secondFighter);

        while(firstFighter.isAlive() && secondFighter.isAlive()){
            Droid attackingDroid = model.pickRandomAttackingDroidAndAttack(firstFighter, secondFighter);
            view.printAttackMove(attackingDroid);
            view.printDroidParameters(firstFighter);
            view.printDroidParameters(secondFighter);
            view.print("\n");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
