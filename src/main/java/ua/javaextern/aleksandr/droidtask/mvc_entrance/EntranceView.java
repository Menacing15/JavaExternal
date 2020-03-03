package ua.javaextern.aleksandr.droidtask.mvc_entrance;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EntranceView {

    private static final String MESSAGES_BUNDLE_NAME = "property/terminal_messages/text";
    public static String getLANGUAGE() {
        return LANGUAGE;
    }



    private ResourceBundle bundle;

    private static String LANGUAGE = "";

    private static final String GUEST_STATUS_REQUEST = "input.guest.status";
    private static final String SIGN_IN_OR_SIGN_UP = "input.sign.in.up";
    private static final String NEW_PASSWORD_REQUEST = "input.new.password";
    private static final String GUEST_PASSWORD_REQUEST = "input.guest.password";
    private static final String INVALID_PASSWORD_FORMAT = "input.bad.format";
    private static final String WRONG_PASSWORD = "input.wrong.password";
    private static final String GREETINGS_FOR_ADMIN = "input.admin.greetings";
    private static final String GREETINGS_FOR_USER = "input.user.greetings";
    private static final String ADMIN_COMMANDS = "admin.commands";
    private static final String USER_COMMANDS = "user.commands";

    public void setUpLanguage() {
        Scanner scanner = new Scanner(System.in);
        print("1 - english, 2 - русский");
        while(!scanner.hasNextInt()){
            print("Type a number!");
            scanner.next();
        }
        setLanguage(scanner.nextInt());
        setBundle();
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
    }

    private void setBundle() {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(LANGUAGE));
    }


    private void print(String message){
        System.out.println(message);
    }

    void printStatusRequest() {
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

    void printSignInOrSignUp() { print(bundle.getString(SIGN_IN_OR_SIGN_UP)); }

    public void printNewPasswordRequest() {
        print(bundle.getString(NEW_PASSWORD_REQUEST));
    }

    public void printGreetingsAndCommandsForAdmin() {
        print(bundle.getString(GREETINGS_FOR_ADMIN));
        print(bundle.getString(ADMIN_COMMANDS));
    }

    public void printGreetingsAndCommandsForUser() {
        print(bundle.getString(GREETINGS_FOR_USER));
        print(bundle.getString(USER_COMMANDS));
    }
}
