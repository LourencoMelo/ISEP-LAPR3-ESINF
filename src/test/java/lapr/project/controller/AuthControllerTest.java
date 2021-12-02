package lapr.project.controller;

import lapr.project.auth.AuthFacade;
import lapr.project.auth.UserRole;
import lapr.project.auth.mappers.UserRoleMapper;
import lapr.project.auth.mappers.dto.UserRoleDTO;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void getUserRoles() {

        AuthController authController = new AuthController();

        AuthFacade authFacade = authController.getApp().getCompany().getAuthFacade();

        authFacade.addUserRole("ola", "olaola");
        authFacade.addUserRole("ola1", "ola1ola1");

        String[] roles = {"ola","ola1"};

        authFacade.addUserWithRoles("ola", "ola@gmail.com", "12345", roles);

        authFacade.doLogin("ola@gmail.com", "12345");

        System.out.println(authFacade.getCurrentUserByUserSession().getRoles());

        List<UserRole> expected = new ArrayList<>();

        UserRole userRole = new UserRole("ola","olaola");
        UserRole userRole1 = new UserRole("ola1","ola1ola1");

        expected.add(userRole);
        expected.add(userRole1);

        UserRoleMapper mapper = new UserRoleMapper();

        for (int i=0; i < authController.getUserRoles().size(); i++){
            assertEquals(authController.getUserRoles().get(i).getId(), mapper.toDTO(expected).get(i).getId());
        }

    }

    @Test
    void getUserRolesNotLoggedIn() {
        AuthController authController = new AuthController();

        AuthFacade authFacade = authController.getApp().getCompany().getAuthFacade();

        authFacade.addUserRole("ola", "olaola");
        authFacade.addUserRole("ola1", "ola1ola1");

        String[] roles = {"ola","ola1"};

        authFacade.addUserWithRoles("ola", "ola@gmail.com", "12345", roles);

        assertEquals(0, authController.getUserRoles().size());
    }
}