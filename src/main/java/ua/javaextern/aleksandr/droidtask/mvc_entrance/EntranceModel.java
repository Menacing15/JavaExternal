package ua.javaextern.aleksandr.droidtask.mvc_entrance;

import ua.javaextern.aleksandr.droidtask.guest.Admin;
import ua.javaextern.aleksandr.droidtask.guest.Guest;
import ua.javaextern.aleksandr.droidtask.guest.User;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntranceModel {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Guest getGuestStatus() throws IOException {
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
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(
                file.getAbsolutePath(),true));
        fileWriter.newLine();
        fileWriter.write(password);
        fileWriter.close();
    }

     File getFile(Guest guest) {
        File file;
        String s  = File.separator;
        String path = "src" + s + "main" + s + "java" + s +
                "property" + s + "passwords"+ s;
        if (guest instanceof Admin) {
            file = new File(path + "admin_passwords.txt");
        } else {
            file = new File(path +"user_passwords.txt");
        }
        return file;
    }

    String getEntranceType() throws IOException {
        String input;
        while(true) {
            input = reader.readLine();
            if(input.equals("sign in") || input.equals("sign up")){
                return input;
            }
        }
    }
}
