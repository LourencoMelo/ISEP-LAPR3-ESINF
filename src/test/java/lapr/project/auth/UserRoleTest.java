package lapr.project.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleTest {

    @Test
    void UserRole(){
        try{
            UserRole role = new UserRole("","");
        }catch (IllegalArgumentException ex){
            assertEquals(ex.getMessage(),"UserRole id and/or description cannot be blank.");
        }
    }

}