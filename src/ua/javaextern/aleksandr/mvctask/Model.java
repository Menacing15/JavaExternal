package ua.javaextern.aleksandr.mvctask;

import java.util.Arrays;

public class Model {

    private int [] log;

    public int rand(int min, int max){
        if(min > max){
            int tmp = min;
            min = max;
            max = tmp;
        }
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }

    public void createLog(int length){
       log = new int[length];
    }

    public void logData(int place, int number){
        log[place] = number;
    }
    public int[] getLog(){
        return log;
    }

    public void updateLog(int attemptsCount){
        log = Arrays.copyOf(log,attemptsCount);
    }
}
