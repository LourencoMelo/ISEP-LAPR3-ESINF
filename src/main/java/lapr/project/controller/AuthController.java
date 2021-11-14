package lapr.project.controller;

import lapr.project.auth.mappers.dto.UserRoleDTO;
import lapr.project.utils.App;

import java.util.Collections;
import java.util.List;

public class AuthController {

    /**
     * Instance of App
     */
    private final App app;

    /**
     * Constructor of the Class
     */
    public AuthController() {
        this.app = App.getInstance();
    }

    /**
     * Does the loggin with the parameters
     * @param email
     * @param pwd
     * @return boolean
     */
    public boolean doLogin(String email, String pwd) {
        try {
            return this.app.doLogin(email, pwd);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Returns the List of the UserRoleDTO
     * @return List<UserRoleDTO>
     */
    public List<UserRoleDTO> getUserRoles() {
        if (this.app.getCurrentUserSession().isLoggedIn()) {
            return this.app.getCurrentUserSession().getUserRoles();
        }
        return Collections.emptyList();
    }

    /**
     * Does the LogOut
     */
    public void doLogout() {
        this.app.doLogout();
    }

    /**
     * Gets the App
     * @return app
     */
    public App getApp() {
        return app;
    }
}
