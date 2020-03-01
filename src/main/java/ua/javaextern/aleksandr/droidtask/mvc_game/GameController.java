package ua.javaextern.aleksandr.droidtask.mvc_game;

import ua.javaextern.aleksandr.droidtask.droid.Droid;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void process(){
        gameView.printGreetings();
        gameView.printDroidList();

        Droid firstFighter = gameModel.chooseDroid();
        gameView.printSecondNumberRequest();
        Droid secondFighter = gameModel.chooseDroid();

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
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!firstFighter.isAlive() || !secondFighter.isAlive()){
                throw new DroidDeadException();
            }
        }
    }
}
