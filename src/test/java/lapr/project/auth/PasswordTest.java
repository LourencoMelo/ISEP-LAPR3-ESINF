package lapr.project.auth;

import lapr.project.model.Company;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {


    @Test
    void Password(){
        String pass = "";
        try{
            Password passTest = new Password(pass);
        }catch (IllegalArgumentException ex){
            assertEquals(ex.getMessage(),"Invalid Email Address.");
        }
    }

    @Test
    void checkPass(){
        Password pass = new Password("123456789");
        boolean result = true;
        result = pass.checkPassword("");
        assertFalse(result);
    }

    @Test
    void checkPass2(){
        Password pass = new Password("123456789");
        boolean result = false;
        result = pass.checkPassword("123456789");
        assertTrue(result);
    }



}