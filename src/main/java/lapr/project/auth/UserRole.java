package lapr.project.auth;

import java.util.Objects;

public class UserRole {

    /**
     * ID of the role
     */
    private final String id;
    /**
     * Description of the Role
     */
    private final String description;

    /**
     * Contructor of the Role
     * @param id
     * @param description
     */
    public UserRole(String id, String description) {
        if (id.isEmpty() || description.isEmpty())
            throw new IllegalArgumentException("UserRole id and/or description cannot be blank.");

        this.id = extractId(id);
        this.description = description;
    }

    /**
     * Extracts teh id
     * @param id
     * @return String
     */
    private String extractId(String id) {
        return id.trim().toUpperCase();
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
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if has Id
     * @param id
     * @return boolean
     */
    public boolean hasId(String id) {
        if (id.isEmpty()) return false;
        return this.id.equals(extractId(id));
    }

    /**
     * Hash Code of the Class
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id.hashCode();
        return hash;
    }

    /**
     * Equals method of the class
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        UserRole obj = (UserRole) o;
        return Objects.equals(this.id, obj.id);
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s - %s", this.id, this.description);
    }
}
