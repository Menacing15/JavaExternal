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

    public boolean isPasswordValid(Guest guest, String password) throws IOException {
        File file;
        if (guest instanceof Admin) {
            file = new File("src\\property\\terminal_messages\\admin_passwords.txt");
        } else {
            file = new File("src\\property\\terminal_messages\\user_passwords.txt");
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
