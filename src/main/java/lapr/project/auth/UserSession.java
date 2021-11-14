package lapr.project.auth;

import lapr.project.auth.mappers.UserRoleMapper;
import lapr.project.auth.mappers.dto.UserRoleDTO;

import java.util.Collections;
import java.util.List;

public class UserSession {

    /**
     * User of the UserSession
     */
    private User user = null;

    /**
     * Contructor of the UserSession
     */
    public UserSession() {
        this.user = null;
    }

    /**
     * Constructor of the UserSession
     * @param user
     */
    public UserSession(User user) {
        if (user == null)
            throw new IllegalArgumentException("Argument cannot be null.");
        this.user = user;
    }

    /**
     * LogsOut the UserSession
     */
    public void doLogout() {
        this.user = null;
    }

    /**
     * Checks if its loggedIn
     * @return boolean
     */
    public boolean isLoggedIn() {
        return this.user != null;
    }

    /**
     * Checks if the User in the Session has the role
     * @param roleId
     * @return boolean
     */
    public boolean isLoggedInWithRole(String roleId) {
        if (isLoggedIn()) {
            return this.user.hasRole(roleId);
        }
        return false;
    }

    /**
     * Gets the UserName
     * @return String
     */
    public String getUserName() {
        if (isLoggedIn())
            return this.user.getName();
        return null;
    }

    /**
     * Gets the User Id
     * @return Email or null
     */
    public Email getUserId() {
        if (isLoggedIn())
            return this.user.getId();
        return null;
    }

    /**
     * Geths the UserRoles in the session
     * @return
     */
    public List<UserRoleDTO> getUserRoles() {
        if (isLoggedIn()) {
            UserRoleMapper mapper = new UserRoleMapper();
            return mapper.toDTO(this.user.getRoles());
        }
        return Collections.emptyList();
    }

    /**
     * Gets the User
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * To String method of the class
     * @return String
     */
    @Override
    public String toString() {
        return "UserSession{" +
                "user=" + user +
                '}';
    }

}
