package ua.javaextern.aleksandr.droidtask;

import ua.javaextern.aleksandr.droidtask.droid.Droid;
import ua.javaextern.aleksandr.droidtask.guest.Guest;

import java.io.*;

public class Serializator implements Serializable{

    public void serialize(Object object, String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(object);
        outputStream.close();
    }

    public Guest deserializeGuest(String path) throws IOException, ClassNotFoundException {    //TODO liquidate duplicate
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        return (Guest) inputStream.readObject();
    }
    public Droid deserializeDroid(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        return (Droid) inputStream.readObject();
    }
}


