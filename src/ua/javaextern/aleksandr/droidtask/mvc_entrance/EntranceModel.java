package ua.javaextern.aleksandr.droidtask.mvc_entrance;

import ua.javaextern.aleksandr.droidtask.Admin;
import ua.javaextern.aleksandr.droidtask.Guest;
import ua.javaextern.aleksandr.droidtask.User;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntranceModel {

    private BufferedReader fileReader;

    public Guest getGuestStatus(BufferedReader terminalReader) throws IOException {
        String status;
        while(true) {
            status = terminalReader.readLine();
            if (status.equals("admin")) {
               return new Admin();
            }else if(status.equals("user")){
                return new User();
            }
            System.out.println("Set your status: 'admin' to sign in as admin, 'user' to sign in as user");
        }
    }

    public boolean validatePassword(Guest guest, String password) throws IOException {
        URL url;
        if(guest instanceof Admin){
            url = getClass().getResource("admin_password.txt");
        }else{
            url = getClass().getResource("user_password.txt");
        }
        File file = new File(url.getPath());
        fileReader = new BufferedReader(new FileReader(file));
        String line;
        while((line = fileReader.readLine()) != null){
            if(password.equals(line)){
                return true;
            }
        }
        return false;
    }

    public String readInputPassword(BufferedReader reader) throws IOException {
        String input;
        String patternString = "\\w+:\\w+";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher;
        while(true) {
            input = reader.readLine();
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                return input;
            }
            System.out.println("Wrong format");
        }
    }
}
