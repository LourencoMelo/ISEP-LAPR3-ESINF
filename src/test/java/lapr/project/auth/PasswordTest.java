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

}