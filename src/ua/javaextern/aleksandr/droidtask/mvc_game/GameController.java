package ua.javaextern.aleksandr.droidtask.mvc_game;

import ua.javaextern.aleksandr.droidtask.droid.Droid;

import java.util.Scanner;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void startDroidBattle(){
        Scanner scanner = new Scanner(System.in);

        gameView.printGreetings();
        gameView.printDroidList();

        Droid firstFighter = gameModel.chooseDroid(scanner);
        gameView.printSecondNumberRequest();
        Droid secondFighter = gameModel.chooseDroid(scanner);

        gameView.printChosenDroidNames(firstFighter,secondFighter);

        while(firstFighter.isAlive() && secondFighter.isAlive()){
            Droid attackingDroid = gameModel.getRandomAttackingDroid(firstFighter, secondFighter);
            Droid defendingDroid = gameModel.getDefendingDroid(attackingDroid, firstFighter, secondFighter);
            attackingDroid.attackMove(defendingDroid);
            gameView.printAttackMove(attackingDroid);
            gameView.printDroidParameters(firstFighter);
            gameView.printDroidParameters(secondFighter);
            gameView.print("\n");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Droid winnerDroid = gameModel.getWinnerDroid(firstFighter, secondFighter);
        gameView.printEndBattle(winnerDroid);
    }
}
