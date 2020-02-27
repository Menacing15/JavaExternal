package main.ua.javaextern.aleksandr.droidtask.mvc_entrance;

import main.ua.javaextern.aleksandr.droidtask.guest.Admin;
import main.ua.javaextern.aleksandr.droidtask.guest.Guest;
import main.ua.javaextern.aleksandr.droidtask.guest.User;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntranceModel {

    Guest getGuestStatus(BufferedReader reader) throws IOException {
        String status;
        while (true) {
            status = reader.readLine();
            if (status.equals("admin")) {
                return new Admin();
            } else if (status.equals("user")) {
                return new User();
            }
        }
    }

    boolean isPasswordValid(Guest guest, String password) throws IOException {
        File file = getFile(guest);
        BufferedReader fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String line;
        while ((line = fileReader.readLine()) != null) {
            if (password.equals(line)) {
                fileReader.close();
                return true;
            }
        }
        return false;
    }

    boolean isPasswordRegular(String input){
        String patternString = "\\w+:\\w+";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher;
        matcher = pattern.matcher(input);
        return matcher.matches();
    }

    void registerNewUser(Guest guest, String password) throws IOException {
        File file = getFile(guest);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter
                (file.getAbsolutePath(),true));
        fileWriter.newLine();
        fileWriter.write(password);
        fileWriter.close();
    }

    private File getFile(Guest guest) {
        File file;
        String s  = File.separator;
        if (guest instanceof Admin) {
            file = new File("src" + s + "property" + s + "passwords"+
                    s +"admin_passwords.txt");
        } else {
            file = new File("src" + s + "property" + s + "passwords"+
                    s +"user_passwords.txt");
        }
        return file;
    }

    String getEntranceType(BufferedReader reader) throws IOException {
        String input;
        while(true) {
            input = reader.readLine();
            if(input.equals("sign in") || input.equals("sign up")){
                return input;
            }
        }
    }
}
