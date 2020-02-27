package main.ua.javaextern.aleksandr.droidtask.mvc_entrance;

import main.ua.javaextern.aleksandr.droidtask.guest.Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EntranceController {
    private EntranceView view;
    private EntranceModel model;

    public EntranceController(EntranceView view, EntranceModel model){
        this.view = view;
        this.model = model;
    }

    public void process() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        view.setUpLanguage();
        view.printStatusRequest();
        Guest guest = model.getGuestStatus(reader);
        view.printSignInOrSignUp();
        if(model.getEntranceType(reader).equals("sign up")){
            view.printNewPasswordRequest();
            model.registerNewUser(guest, getRightPasswordFormat(reader));
        }
        view.printLoginPasswordRequest();
        validatePassword(reader, guest);
    }


    private void validatePassword(BufferedReader reader, Guest guest) throws IOException {
        String password;
        while(true) {
            password = getRightPasswordFormat(reader);
            if (model.isPasswordValid(guest, password)) {
                break;
            }
            view.printWrongPassword();
        }
    }

    private String getRightPasswordFormat(BufferedReader terminalReader) throws IOException {
        String password;
        while (!model.isPasswordRegular(password = terminalReader.readLine())){
            view.printInvalidPasswordFormat();
        }
        return password;
    }
}
