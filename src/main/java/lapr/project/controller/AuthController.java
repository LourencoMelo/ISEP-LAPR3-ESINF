package lapr.project.controller;

import lapr.project.auth.mappers.dto.UserRoleDTO;
import lapr.project.utils.App;

import java.util.List;

public class AuthController {
    private App app;

    public AuthController() {
        this.app = App.getInstance();
    }

    public boolean doLogin(String email, String pwd) {
        try {
            return this.app.doLogin(email, pwd);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public List<UserRoleDTO> getUserRoles() {
        if (this.app.getCurrentUserSession().isLoggedIn()) {
            return this.app.getCurrentUserSession().getUserRoles();
        }
        return null;
    }

    public void doLogout() {
        this.app.doLogout();
    }

    public App getApp() {
        return app;
    }
}
