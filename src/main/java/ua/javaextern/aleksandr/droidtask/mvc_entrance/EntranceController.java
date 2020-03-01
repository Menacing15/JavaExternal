package ua.javaextern.aleksandr.droidtask.mvc_entrance;

import ua.javaextern.aleksandr.droidtask.guest.Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EntranceController {
    private EntranceView view;
    private EntranceModel model;
    private BufferedReader reader;

    public EntranceController(EntranceView view, EntranceModel model){
        this.view = view;
        this.model = model;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void process() throws IOException {
        view.setUpLanguage();
        view.printStatusRequest();
        Guest guest = model.getGuestStatus();
        view.printSignInOrSignUp();
        if(model.getEntranceType().equals("sign up")){
            view.printNewPasswordRequest();
            model.registerNewUser(guest, getRightPasswordFormat());
        }
        view.printLoginPasswordRequest();
        validatePassword(guest);
    }


    private void validatePassword(Guest guest) throws IOException {
        String password;
        while(true) {
            password = getRightPasswordFormat();
            if (model.isPasswordValid(guest, password)) {
                break;
            }
            view.printWrongPassword();
        }
    }

    private String getRightPasswordFormat() throws IOException {
        String password;
        while (!model.isPasswordRegular(password = reader.readLine())){
            view.printInvalidPasswordFormat();
        }
        return password;
    }
}
