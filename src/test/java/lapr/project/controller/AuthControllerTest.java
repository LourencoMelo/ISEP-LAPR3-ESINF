package lapr.project.controller;

import lapr.project.auth.AuthFacade;
import lapr.project.model.Company;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {



    @Test
    void doLogin() {
        AuthController authController = new AuthController();

        assertTrue(authController.doLogin("joao@gmail.com","12345"));

    }

    @Test
    void getUserRolesTest() {
        AuthController authController = new AuthController();

        Company company = App.getInstance().getCompany();

        AuthFacade authFacade = company.getAuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        assertEquals(1,authController.getUserRoles().size());
    }

    @Test
    void getUserNotLoggedInRoles() {
        AuthController authController = new AuthController();
        Company company = App.getInstance().getCompany();

        AuthFacade authFacade = company.getAuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        assertNull(authController.getUserRoles());
    }

    @Test
    void logOutTest() {
        AuthController authController = new AuthController();

        Company company = App.getInstance().getCompany();

        AuthFacade authFacade = company.getAuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        authController.doLogout();

        assertNull(authFacade.getCurrentUserSession().getUser());

    }

    @Test
    void getAppTest() {
        AuthController authController = new AuthController();
        assertEquals(App.getInstance(), authController.getApp());
    }
}