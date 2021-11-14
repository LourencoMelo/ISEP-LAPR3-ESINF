package lapr.project.auth.mappers.dto;

public class UserRoleDTO {

    /**
     * Creates the instance id
     */
    private final String id;
    /**
     * Creates the instance description
     */
    private final String description;

    /**
     * Constructor of UserRoleDTO
     * @param id
     * @param description
     */
    public UserRoleDTO(String id, String description)
    {
        this.id = id;
        this.description = description;
    }

    /**
     * Returns the ID
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the Description
     * @return description
     */
    public String getDescription() {
        return description;
    }

}
