package ua.javaextern.aleksandr.droidtask;

import org.apache.log4j.Logger;
import ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceController;
import ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceModel;
import ua.javaextern.aleksandr.droidtask.mvc_entrance.EntranceView;
import ua.javaextern.aleksandr.droidtask.mvc_game.*;
import java.io.IOException;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        EntranceModel entranceModel = new EntranceModel();
        EntranceView entranceView = new EntranceView();
        EntranceController entranceController = new EntranceController(entranceView,entranceModel);

        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
        try {
            entranceController.process();
            gameController.process();
        } catch (IOException e) {
            log.fatal("IOException: ", e);
        }



    }
}
