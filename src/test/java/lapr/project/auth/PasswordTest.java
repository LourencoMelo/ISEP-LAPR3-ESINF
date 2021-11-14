package lapr.project.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {


    @Test
    void Password(){
        try{
            new Password("");
        }catch (IllegalArgumentException ex){
            assertEquals(ex.getMessage(),"Invalid Email Address.");
        }
    }

    @Test
    void equalTest(){
        Password password = new Password("123456789");
        Password password1 = new Password("123456789");

        assertFalse(password.equals(password1));
    }

    @Test
    void equalTest2(){
        Password password = new Password("123456789");

        assertFalse(password.equals(null));
    }

    @Test
    void equalTest3(){
        Password password = new Password("123456789");

        assertFalse(password.equals("ola"));
    }





}