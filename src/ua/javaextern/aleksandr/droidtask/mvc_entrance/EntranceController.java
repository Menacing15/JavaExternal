package ua.javaextern.aleksandr.droidtask.mvc_entrance;

import ua.javaextern.aleksandr.droidtask.Guest;

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
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
        view.setUp();
        view.printGuestStatusRequest();
        Guest guest = model.getGuestStatus(terminalReader);
        view.printLoginPasswordRequest();
        String password;
        while(true) {
            password = getPassword(terminalReader);
            if (model.isPasswordValid(guest, password)) {
                break;
            }
            view.printWrongPassword();
        }

    }

    private String getPassword(BufferedReader terminalReader) throws IOException {
        String password;
        while (!model.checkPasswordRegularity(password = terminalReader.readLine())){
            view.printInvalidPasswordFormat();
        }
        return password;
    }
}
