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

    @Test
    void UserRole2(){
        try{
            UserRole role = new UserRole("STUDENT","");
        }catch (IllegalArgumentException ex){
            assertEquals(ex.getMessage(),"UserRole id and/or description cannot be blank.");
        }
    }

    @Test
    void getId(){
        UserRole role = new UserRole("STUDENT","Student of school");
        String expected = "Student of school";
        String result = role.getDescription();
        assertEquals(expected,result);
    }

    @Test
    void hasId(){
        UserRole role = new UserRole("STUDENT","Student of school");
        boolean result = true;
        result =  role.hasId("");
        assertFalse(result);
    }

    @Test
    void equalTest(){
        UserRole role = new UserRole("STUDENT","Student of school");
        UserRole role2 = new UserRole("STUDENT","Student of school");

        assertTrue(role.equals(role2));
    }

    @Test
    void equalTest2(){
        UserRole role = new UserRole("STUDENT","Student of school");

        assertFalse(role.equals(null));
    }




}