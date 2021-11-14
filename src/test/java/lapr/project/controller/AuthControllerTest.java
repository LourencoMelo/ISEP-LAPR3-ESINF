package lapr.project.controller;

import lapr.project.auth.AuthFacade;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    @Test
    void constructor() {
        AuthController authController = new AuthController();

        assertEquals(authController.getApp(), App.getInstance());
    }

    @Test
    void doLogOutTest() {
        AuthController authController = new AuthController();

        AuthFacade authFacade = authController.getApp().getCompany().getAuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        authController.doLogout();

        assertNull(authController.getApp().getCurrentUserSession().getUser());
    }
}