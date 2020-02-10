package ua.javaextern.aleksandr.mvctask;

import java.util.Arrays;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view,Model model){
        this.view = view;
        this.model = model;
    }

    public void run(int min, int max, int attempts){
        view.type(String.format("Hi! Let's try a game. " +
                "You have %d attempts to guess a number from %d to %d. Type your number!",attempts , min, max));

        int magicNumber = model.rand(min,max);
        boolean isGuessed = false;
        model.createLog(attempts);

        for(int attemptCount = 0; attemptCount < attempts; attemptCount++){
            int typedNumber = view.read();

            if(typedNumber == magicNumber){
                model.updateLog(attemptCount);
                view.type("Great you've guessed the number! Well done!\n");
                isGuessed = true;
                break;
            }else{
                String message;
                if(magicNumber > typedNumber && typedNumber > min){
                    message = String.format("Magic number is greater than yours! " +
                            "It lays in range from %d to %d. Try again!", typedNumber, max);
                    min = typedNumber;
                }else if(typedNumber > magicNumber && typedNumber < max){
                    message = String.format("Magic number is less than yours! " +
                            "It lays in range from %d to %d. Try again!", min ,typedNumber);
                    max = typedNumber;
                }else{
                    message = String.format("Magic number should be in range from %d to %d\n" +
                            "Be more attentive, mistake's cost you an attempt...", min ,max);
                }
                view.type("Wrong! " + message);
            }
            model.logData(attemptCount,typedNumber);
        }
        if(!isGuessed) {
            view.type("\nNo more attempts left! Dummy, you've lost!\n");
        }
        printStats();
    }

    private void printStats(){
        if(model.getLog().length == model.getLogLengthPrimal()){
            view.type("Pathetic defeat...");
        }else {
            view.type("Amazing victory!");
        }
        view.type("*********************************************************");
        view.type("Stats:");
        view.type("Your numbers while guessing: " + Arrays.toString(model.getLog()));
        view.type("Attempt count is: " + model.getLog().length);

    }
}
