package lapr.project.auth;

import java.util.*;

public class User {

    /**
     * Email Class in a instance
     */
    private Email id;
    /**
     * Password Class in a instance
     */
    private final Password password;
    /**
     * Name of the User
     */
    private String name;
    /**
     * Set of UserRole
     */
    private final Set<UserRole> roles = new HashSet<>();

    /**
     * Constructor of User
     * @param id
     * @param pwd
     * @param name
     */
    public User(Email id, Password pwd, String name) {
        if ((Objects.isNull(id)) || Objects.isNull(pwd) || name.isEmpty() )
            throw new IllegalArgumentException("User cannot have an id, password or name as null/blank.");

        this.id = id;
        this.password = pwd;
        this.name = name.trim();
    }

    /**
     * Gets the Id of the User
     * @return Email
     */
    public Email getId() {
        return id;
    }

    /**
     * Sets the Id of the User
     * @param id
     */
    public void setId(Email id) {
        this.id = id;
    }

    /**
     * Sets the Name of the User
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Name of the User
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if it has ID
     * @param id
     * @return boolean
     */
    public boolean hasId(Email id) {
        return this.id.equals(id);
    }

    /**
     * Checks if it has password
     * @param pwd
     * @return pwd
     */
    public boolean hasPassword(String pwd) {
        return this.password.checkPassword(pwd);
    }

    /**
     * Adds a role to the User
     * @param role
     * @return boolean
     */
    public boolean addRole(UserRole role) {
        if (role != null)
            return this.roles.add(role);
        return false;
    }

    /**
     * Removes the Role
     * @param role
     * @return boolean
     */
    public boolean removeRole(UserRole role) {
        if (role != null)
            return this.roles.remove(role);
        return false;
    }

    /**
     * Checks if has Role
     * @param role
     * @return boolean
     */
    public boolean hasRole(UserRole role) {
        return this.roles.contains(role);
    }

    /**
     * Checks if has Role with roleId
     * @param roleId
     * @return
     */
    public boolean hasRole(String roleId) {
        for (UserRole role : this.roles) {
            if (role.hasId(roleId))
                return true;
        }
        return false;
    }

    /**
     * Gets the Roles in a List
     * @return the List of UserRole
     */
    public List<UserRole> getRoles() {
        List<UserRole> list = new ArrayList<>();
        for (UserRole role : this.roles)
            list.add(role);
        return Collections.unmodifiableList(list);
    }

    /**
     * Hash Code of the class
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
        User obj = (User) o;
        return Objects.equals(this.id, obj.id);
    }

    /**
     * To String of the class
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.id.toString(), this.name, this.password);
    }

    /**
     * Gets it's own passowrd
     * @return password
     */
    public Password getPassword() {
        return password;
    }
}
