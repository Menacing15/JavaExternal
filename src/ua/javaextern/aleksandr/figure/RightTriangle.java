package ua.javaextern.aleksandr.figure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RightTriangle {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        int size = getSize();

        System.out.print("*\n");

        for(int i = 1; i < size - 1; i++){
            System.out.print("* ");
            for(int j = 1; j < i; j++){
                System.out.print("  ");
            }
            System.out.print("*\n");
        }

        for(int i = 0; i != size; i++) {
            System.out.print("* ");
        }

    }

    public static int getSize () throws IOException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please insert the size");
        int size = Integer.parseInt(reader.readLine());
        if(size < 2){
            throw new IllegalAccessException("invalid parameters");
        }
        return size;
    }
}
