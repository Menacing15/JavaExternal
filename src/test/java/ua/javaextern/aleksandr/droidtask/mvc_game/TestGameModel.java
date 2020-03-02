package ua.javaextern.aleksandr.droidtask.mvc_game;

import org.junit.Before;
import org.junit.Test;
import ua.javaextern.aleksandr.droidtask.ConfigurableInputStream;
import ua.javaextern.aleksandr.droidtask.droid.BatDroid;
import ua.javaextern.aleksandr.droidtask.droid.Droid;
import ua.javaextern.aleksandr.droidtask.droid.KarateDroid;
import ua.javaextern.aleksandr.droidtask.droid.PizzaDroid;

import static org.junit.Assert.assertTrue;

public class TestGameModel {

    private GameModel model;
    private ConfigurableInputStream in;

    @Before
    public void setup(){
        model = new GameModel();
        in = new ConfigurableInputStream();

        System.setIn(in);
    }

    @Test
    public void chooseDroidTestBatDroid(){
        in.add("1");
        Droid testDroid = model.chooseDroid();
        assertTrue(testDroid instanceof BatDroid);
    }
    @Test
    public void chooseDroidTestPizzaDroid(){
        in.add("2");
        Droid testDroid = model.chooseDroid();
        assertTrue(testDroid instanceof PizzaDroid);
    }
    @Test
    public void chooseDroidTestKarateDroid(){
        in.add("3");
        Droid testDroid = model.chooseDroid();
        assertTrue(testDroid instanceof KarateDroid);
    }
    @Test
    public void getRandomAttackingDroid(){
        Droid randomDroid = model.getRandomAttackingDroid(new KarateDroid(),new BatDroid());
        assertTrue(randomDroid instanceof KarateDroid || randomDroid instanceof BatDroid);
    }
    @Test
    public void getDefendingDroid(){
        Droid karateDroid = new KarateDroid();
        Droid batDroid = new BatDroid();
        Droid attackingDroid = karateDroid;
        Droid defendingDroid = model.getDefendingDroid(karateDroid,batDroid,attackingDroid);

        assertTrue(defendingDroid instanceof BatDroid);
    }
    @Test
    public void getWinnerDroid(){
        Droid winnerDroid = new BatDroid("winner",1,1,1);
        Droid loserDroid = new PizzaDroid("loser",1,1,0);
        assertTrue(model.getWinnerDroid(winnerDroid,loserDroid) instanceof BatDroid);
    }

}
