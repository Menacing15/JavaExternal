package ua.javaextern.aleksandr.droidtask.mvc;

import ua.javaextern.aleksandr.droidtask.droid.Droid;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    private static final String MESSAGES_BUNDLE_NAME = "property/text";

    private ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
            new Locale(""));

    private static final String SPACE_SIGN = " ";
    private static final String COMMA_SIGN = ",";
    private static final String NEXT_LINE = "\n";

    private static final String GREETINGS = "input.greetings";
    private static final String DROIDS_LIST = "input.droid.list";
    private static final String DROID_NAMES_ANNOUNCEMENT = "input.names.announcement";
    private static final String DROID_ATTACK_MOVE = "input.attack.move";
    private static final String DROID_PARAMETERS = "input.droid.parameters";
    private static final String SECOND_NUMBER_REQUEST = "input.number.request";

    public void print(String message){
        System.out.println(message);
    }

    public void printGreetings(){
        print(bundle.getString(GREETINGS));
    }

    public void printDroidList(){
        print(bundle.getString(DROIDS_LIST));
    }

    public void printChosenDroidNames(Droid firstFighter, Droid secondFighter){
        print(bundle.getString(DROID_NAMES_ANNOUNCEMENT) +
                SPACE_SIGN + firstFighter.getName() + COMMA_SIGN +
                SPACE_SIGN + secondFighter.getName() + NEXT_LINE);
    }

    public void printAttackMove(Droid droid){
        print(droid.getName() + SPACE_SIGN + bundle.getString(DROID_ATTACK_MOVE));
    }

    public void printDroidParameters(Droid droid){
        print(droid.getName() + SPACE_SIGN + bundle.getString(DROID_PARAMETERS) + SPACE_SIGN +
                droid.getArmorValue() + SPACE_SIGN + droid.getHealthValue());
    }
    public void printSecondNumberRequest(){
        print(bundle.getString(SECOND_NUMBER_REQUEST));
    }
}
