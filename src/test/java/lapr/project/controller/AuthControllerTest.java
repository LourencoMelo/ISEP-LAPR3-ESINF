package lapr.project.controller;

import lapr.project.auth.AuthFacade;
import lapr.project.auth.UserRole;
import lapr.project.auth.mappers.UserRoleMapper;
import lapr.project.auth.mappers.dto.UserRoleDTO;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    @Test
    void constructor() {
        AuthController authController = new AuthController();

        assertEquals(authController.getApp(), App.getInstance());
    }

    @Test
    void doLogin() {

        AuthController authController = new AuthController();

        assertTrue(authController.doLogin("joao@gmail.com", "12345"));
        authController.doLogout();
        assertFalse(authController.doLogin("joao1@gmail.com", "12345"));
        authController.doLogout();
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

    @Test
    void getUserRoles() {

        AuthController authController = new AuthController();

        AuthFacade authFacade = authController.getApp().getCompany().getAuthFacade();

        authFacade.doLogin("joao@gmail.com", "12345");

        System.out.println(authFacade.getCurrentUserByUserSession().getRoles());

        List<UserRole> expected = new ArrayList<>();

        UserRole userRole = new UserRole("TrafficManager","TrafficManager");

        expected.add(userRole);

        UserRoleMapper mapper = new UserRoleMapper();

        List<UserRoleDTO> dtoList = new ArrayList<>();

        dtoList.add(mapper.toDTO(expected).get(0));

        assertEquals(dtoList.size(),authController.getUserRoles().size());
        assertEquals(dtoList.get(0).getId(),authController.getUserRoles().get(0).getId());

        authController.doLogout();

    }

    @Test
    void getUserRolesNotLoggedIn() {
        AuthController authController = new AuthController();

        AuthFacade authFacade = authController.getApp().getCompany().getAuthFacade();

        authFacade.addUserRole("ola", "olaola");
        authFacade.addUserRole("ola1", "ola1ola1");

        String[] roles = {"ola","ola1"};

        authFacade.addUserWithRoles("ola", "ola@gmail.com", "12345", roles);

        assertEquals(Collections.emptyList(), authController.getUserRoles());
    }
}