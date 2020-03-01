package ua.javaextern.aleksandr.droidtask.mvc_entrance;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ua.javaextern.aleksandr.droidtask.ConfigurableInputStream;
import ua.javaextern.aleksandr.droidtask.guest.Admin;
import ua.javaextern.aleksandr.droidtask.guest.Guest;
import ua.javaextern.aleksandr.droidtask.guest.User;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEntranceModel {

    private EntranceModel model;
    private ConfigurableInputStream in;

    @Before
    public void setup(){
        model = new EntranceModel();
        in = new ConfigurableInputStream();

        System.setIn(in);
    }
    @Ignore
    public void getGuestStatus() throws IOException {
        in.add("admin");                              //TODO proper test, BufferedReader doesnt read from ConfigurableInputStream
        Guest guest = model.getGuestStatus();
        assertTrue(guest instanceof Admin);
    }
    @Test
    public void isPasswordValidAdminCase() throws IOException {
        assertTrue(model.isPasswordValid(new Admin(), "admin:admin"));
    }
    @Test
    public void isPasswordValidUserCase() throws IOException {
        assertTrue(model.isPasswordValid(new User(), "user:user"));
    }
    @Test
    public void isPasswordValidWrongCase() throws IOException {
        assertFalse(model.isPasswordValid(new User(), "use:use"));
    }
    @Test
    public void isPasswordRegularRightCase() {
        assertTrue(model.isPasswordRegular("admin:admin"));
        assertTrue(model.isPasswordRegular( "a:a"));
    }
    @Test
    public void isPasswordRegularWrongCase() {
        assertFalse(model.isPasswordRegular("admin_admin"));
        assertFalse(model.isPasswordRegular("admin"));
    }
    @Test
    public void registerUser() throws IOException {
        Guest guest = new User();
        String newPassword = "new:password";
        model.registerNewUser(guest,newPassword);
        assertTrue(model.isPasswordValid(guest, newPassword));
    }

}
