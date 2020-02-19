package main.ua.javaextern.aleksandr.droidtask.mvc_entrance;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EntranceView {

    private static final String MESSAGES_BUNDLE_NAME = "property/terminal_messages/text";
    private static String LANGUAGE = "";
    private ResourceBundle bundle;

    private static final String SPACE_SIGN = " ";
    private static final String NEXT_LINE = "\n";

    private static final String GUEST_STATUS_REQUEST = "input.guest.status";
    private static final String GUEST_PASSWORD_REQUEST = "input.guest.password";
    private static final String INVALID_PASSWORD_FORMAT = "input.bad.format";
    private static final String WRONG_PASSWORD = "input.wrong.password";

    public void setUp() {
        Scanner scanner = new Scanner(System.in);
        print("1 - english, 2 - русский");
        while(!scanner.hasNextInt()){
            print("Type a number!");
            scanner.next();
        }
        setLanguage(scanner.nextInt());
    }

    private void setLanguage(int i) {
        switch (i) {
            case 1:
                LANGUAGE = "";
                break;
            case 2:
                LANGUAGE = "ru";
                break;
        }
        setBundle();
    }

    private void setBundle() {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(LANGUAGE));
    }


    private void print(String message){
        System.out.println(message);
    }

    void printGuestStatusRequest() {
        print(bundle.getString(GUEST_STATUS_REQUEST));
    }

    void printLoginPasswordRequest() {
        print(bundle.getString(GUEST_PASSWORD_REQUEST));
    }

    void printWrongPassword() {
        print(bundle.getString(WRONG_PASSWORD));
    }

    void printInvalidPasswordFormat() {
        print(bundle.getString(INVALID_PASSWORD_FORMAT));
    }
}
