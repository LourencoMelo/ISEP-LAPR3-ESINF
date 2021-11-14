package lapr.project.controller;

import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    @Test
    void constructor() {
        AuthController authController = new AuthController();

        assertEquals(authController.getApp(), App.getInstance());
    }
}