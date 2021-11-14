package lapr.project.auth.mappers.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleDTOTest {

    @Test
    void constructor() {
        UserRoleDTO userRoleDTO = new UserRoleDTO("ADMIN","ADMIN");

        assertEquals("ADMIN", userRoleDTO.getId());
        assertEquals("ADMIN", userRoleDTO.getDescription());

    }
}