package lapr.project.model;

import lapr.project.auth.AuthFacade;
import lapr.project.auth.Email;
import lapr.project.auth.User;
import lapr.project.auth.store.UserStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthFacadeTest {


    @Test
    void addUser() {

        UserStore users = new UserStore();
        User user = users.create("João", "joao@gmail.com", "12345");

        assertTrue(users.add(user));
    }

    @Test
    void roleNotPresent() {
        AuthFacade authFacade = new AuthFacade();

        assertFalse(authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "ola"));

    }

    @Test
    void userWithMultipleRoles() {
        AuthFacade authFacade = new AuthFacade();

        String[] roles = {"TrafficManager"};

        assertTrue(authFacade.addUserWithRoles("joao", "joao@gmail.com", "12345", roles));

    }

    @Test
    void existentUser() {
        AuthFacade authFacade = new AuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        authFacade.existsUser("ola@gmail.com");
    }

    @Test
    void LogOutTest() {

        AuthFacade authFacade = new AuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        authFacade.doLogout();

        assertNull(authFacade.getUserSession().getUser());
    }

    @Test
    void currentUserSession() {

        AuthFacade authFacade = new AuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        assertEquals(authFacade.getCurrentUserSession(), authFacade.getUserSession());
    }

    @Test
    void currentUser() {

        AuthFacade authFacade = new AuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        assertEquals(authFacade.getCurrentUserByUserSession(), authFacade.getUserSession().getUser());

    }

    @Test
    void changeEmail() {

        AuthFacade authFacade = new AuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        authFacade.changeEmailFromUserByLastEmail("joao@gmail.com","ola@gmail.com");

        Email email = new Email("ola@gmail.com");

        assertEquals(email.toString(), authFacade.getCurrentUserByUserSession().getId().toString());
    }

    @Test
    void userToSendTest() {

        AuthFacade authFacade = new AuthFacade();

        authFacade.addUserRole("Traffic Manager", "Traffic Manager");

        authFacade.addUserWithRole("Joao", "joao@gmail.com", "12345", "Traffic Manager");

        authFacade.doLogin("joao@gmail.com", "12345");

        assertEquals(authFacade.getUserToSend(),authFacade.getCurrentUserByUserSession());

    }
}
