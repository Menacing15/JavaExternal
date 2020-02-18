package ua.javaextern.aleksandr.droidtask.mvc_entrance;

import ua.javaextern.aleksandr.droidtask.Admin;
import ua.javaextern.aleksandr.droidtask.Guest;
import ua.javaextern.aleksandr.droidtask.User;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntranceModel {

    private BufferedReader fileReader;

    public Guest getGuestStatus(BufferedReader terminalReader) throws IOException {
        String status;
        while (true) {
            status = terminalReader.readLine();
            if (status.equals("admin")) {
                return new Admin();
            } else if (status.equals("user")) {
                return new User();
            }
        }
    }

    public boolean validatePassword(Guest guest, String password) throws IOException {
        URL url;
        if(guest instanceof Admin){
            url = getClass().getResource("admin_password.txt");
        }else{
            url = getClass().getResource("user_password.txt");
        }
        fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String line;
        while ((line = fileReader.readLine()) != null) {
            if (password.equals(line)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPasswordRegularity(String input) throws IOException {
        String patternString = "\\w+:\\w+";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher;
        matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        System.out.println("Wrong format");
        return false;
    }
}
