package bysong.app.application;

import bysong.app.domain.User;

/**
 * Created by Lucas on 15/09/2016.
 */
public class Application {

    private static Application instance;

    public static Application getInstance() {

        if (instance == null) {
            instance = new Application();

        }

        return instance;
    }

    private Application() {
    }

    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}