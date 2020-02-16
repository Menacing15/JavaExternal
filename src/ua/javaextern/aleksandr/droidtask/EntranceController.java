package ua.javaextern.aleksandr.droidtask;

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
        String password;
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
        view.printGuestStatusRequest();
        Guest guest = model.getGuestStatus(terminalReader);
        view.printLoginPasswordRequest();
        password = model.readInputPassword(terminalReader);
        model.validatePassword(guest,password);
    }
}
