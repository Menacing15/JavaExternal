package ua.javaextern.aleksandr.droidtask;

import ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceController;
import ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceModel;
import ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceView;
import ua.javaextern.aleksandr.droidtask.mvc_game.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EntranceModel entranceModel = new EntranceModel();
        EntranceView entranceView = new EntranceView();
        EntranceController entranceController = new EntranceController(entranceView,entranceModel);
        try {
            entranceController.process();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
        gameController.startDroidBattle();
    }
}
