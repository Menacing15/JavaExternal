package ua.javaextern.aleksandr.mvctask;

import java.util.Scanner;

public class View {
    public void type(String message){
        System.out.println(message);
    }

    public int read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
