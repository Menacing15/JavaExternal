package ua.javaextern.aleksandr.mvctask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    public void type(String message){
        System.out.println(message);
    }

    public int read() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Dummy, you need a number...");
            return read();
        }
    }
}
