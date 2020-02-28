package ua.javaextern.aleksandr.droidtask;

import ua.javaextern.aleksandr.droidtask.droid.Droid;

import java.io.*;

public class Serializator {
    private String s = File.separator;
    private String destination = "src" + s + "main" + s + "java" + s + "property"
                    + s + "serialized";

    void serialize(Droid droid) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(droid);
        outputStream.close();
    }

    Droid deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(destination);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        return (Droid) inputStream.readObject();
    }
}


