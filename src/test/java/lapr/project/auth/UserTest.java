package lapr.project.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void constructorFail() {
        Email email = null;
        Password password = new Password("12345");

        try{
            new User(email,password,"joao");
        }catch (IllegalArgumentException exception){
            assertEquals(exception.getMessage(), "User cannot have an id, password or name as null/blank.");
        }

        Email email1 = new Email("ola@gmail.com");
        Password password1 = null;

        try{
            new User(email1,password1,"diana");
        }catch (IllegalArgumentException exception){
            assertEquals(exception.getMessage(), "User cannot have an id, password or name as null/blank.");
        }

        try {
            new User(email1,password,"");
        }catch (IllegalArgumentException exception){
            assertEquals(exception.getMessage(), "User cannot have an id, password or name as null/blank.");
        }
    }

    @Test
    void setIdTest() {
        Email email = new Email("joana@gmail.com");
        Email email1 = new Email("joaninha@gmail.com");
        Password password = new Password("12345");
        User user = new User(email,password,"joana");

        user.setId(email1);

        assertEquals(email1, user.getId());
    }

    @Test
    void setNameTest() {
        Email email = new Email("joana@gmail.com");
        Password password = new Password("12345");
        User user = new User(email,password,"joana");

        user.setName("joaninha");

        assertEquals("joaninha",user.getName());
    }

    @Test
    void addUserRoleTestFail() {
        Email email = new Email("joana@gmail.com");
        Password password = new Password("12345");
        User user = new User(email,password,"joana");

        UserRole userRole = null;

        assertFalse(user.addRole(userRole));
    }

    @Test
    void removeRoleTest() {
        Email email = new Email("joana@gmail.com");
        Password password = new Password("12345");
        User user = new User(email,password,"joana");

        UserRole userRoleLegit = new UserRole("ADMIN","ADMIN");
        UserRole userRoleLegit2 = new UserRole("OLA","OLA");
        UserRole userRole = null;

        user.addRole(userRoleLegit);


        assertFalse(user.removeRole(userRole));
        assertTrue(user.removeRole(userRoleLegit));
        assertFalse(user.removeRole(userRoleLegit2));

    }
}