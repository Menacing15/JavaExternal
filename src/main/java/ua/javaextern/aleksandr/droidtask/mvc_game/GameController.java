package ua.javaextern.aleksandr.droidtask.mvc_game;

import ua.javaextern.aleksandr.droidtask.Serializator;
import ua.javaextern.aleksandr.droidtask.droid.BatDroid;
import ua.javaextern.aleksandr.droidtask.droid.Droid;
import ua.javaextern.aleksandr.droidtask.guest.Admin;
import ua.javaextern.aleksandr.droidtask.guest.Guest;

import java.io.File;
import java.io.IOException;

public class GameController {

    private GameModel gameModel;
    private GameView gameView;
    private Serializator serializator = new Serializator();

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void process() throws IOException, ClassNotFoundException {
        Guest guest = serializator.deserializeGuest(String.join(
                File.separator, "src", "main", "java", "property", "serialized", "guest.ser"));
        Droid firstFighter;
        Droid secondFighter;
        gameView.printGreetings();
        guest.processUser();
        if(guest instanceof Admin){
            gameView.printDroidList();
            firstFighter = gameModel.chooseDroid();
            gameView.printSecondNumberRequest();
            secondFighter = gameModel.chooseDroid();
        }else{
            firstFighter = serializator.deserializeDroid(
                    String.join(File.separator, "src", "main", "java", "property", "serialized", "first.ser"));
            secondFighter = serializator.deserializeDroid(
                    String.join(File.separator, "src", "main", "java", "property", "serialized", "second.ser"));
        }
        gameView.printChosenDroidNames(firstFighter,secondFighter);

        try{
            processFight(firstFighter, secondFighter);
        }catch(DroidDeadException ex){
            Droid winnerDroid = gameModel.getWinnerDroid(firstFighter, secondFighter);
            gameView.printEndBattle(winnerDroid);
        }
    }

    private void processFight(Droid firstFighter, Droid secondFighter) throws DroidDeadException {
        while(true){
            Droid attackingDroid = gameModel
                    .getRandomAttackingDroid(firstFighter, secondFighter);
            Droid defendingDroid = gameModel
                    .getDefendingDroid(attackingDroid, firstFighter, secondFighter);
            attackingDroid.attackMove(defendingDroid);
            gameView.printAttackMove(attackingDroid);
            gameView.printDroidParameters(firstFighter);
            gameView.printDroidParameters(secondFighter);
            gameView.print("\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!firstFighter.isAlive() || !secondFighter.isAlive()){
                throw new DroidDeadException();
            }
        }
    }


}
