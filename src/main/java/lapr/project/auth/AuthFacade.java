package lapr.project.auth;

import lapr.project.auth.store.Files;
import lapr.project.auth.store.UserRoleStore;
import lapr.project.auth.store.UserStore;

import java.util.Optional;

public class AuthFacade {

    /**
     * UserSession of AuthFacade
     */
    private UserSession userSession;
    /**
     * UserRoleStore of AuthFacade
     */
    private final UserRoleStore roles;
    /**
     * UserStore of AuthFacade
     */
    private final UserStore users;
    /**
     * User userToSend of AuthFacde
     */
    private User userToSend;

    /**
     * Contructor of AuthFacade
     */
    public AuthFacade() {
        this.userSession = new UserSession();
        this.roles = new UserRoleStore();
        this.users = new UserStore();
    }

    /**
     * Adds UserRole
     * @param id
     * @param description
     * @return boolean
     */
    public boolean addUserRole(String id, String description) {
        UserRole role = this.roles.create(id, description);
        return this.roles.add(role);
    }

    /**
     * Adds User
     * @param name
     * @param email
     * @param pwd
     * @return boolean
     */
    public boolean addUser(String name, String email, String pwd) {
        User user = this.users.create(name, email, pwd);
        return this.users.add(user);
    }

    /**
     * Adds User With Role
     * @param name
     * @param email
     * @param pwd
     * @param roleId
     * @return boolean
     */
    public boolean addUserWithRole(String name, String email, String pwd, String roleId) {
        Files.writeToAFileAboutPasswords(roleId, email, pwd);
        Optional<UserRole> roleResult = this.roles.getById(roleId);
        if (!roleResult.isPresent())
            return false;

        User user = this.users.create(name, email, pwd);
        user.addRole(roleResult.get());
        return this.users.add(user);

    }

    /**
     * Adds User With Various Roles
     * @param name
     * @param email
     * @param pwd
     * @param rolesId
     * @return boolean
     */
    public boolean addUserWithRoles(String name, String email, String pwd, String[] rolesId) {
        User user = this.users.create(name, email, pwd);
        for (String roleId : rolesId) {
            Optional<UserRole> roleResult = this.roles.getById(roleId);
            if (roleResult.isPresent())
                user.addRole(roleResult.get());
        }


        return this.users.add(user);
    }

    /**
     * Returns a boolean if exists User
     * @param email
     * @return boolean
     */
    public boolean existsUser(String email) {
        return this.users.exists(email);
    }

    /**
     * Login
     * @param email
     * @param password
     * @return UserSession
     */
    public UserSession doLogin(String email, String password) {
        Optional<User> result = this.users.getById(email);
        if (result.isPresent()) {
            User user = result.get();
            this.userToSend = user;
            if (user.hasPassword(password)) {
                this.userSession = new UserSession(user);
            }
        }
        return this.userSession;
    }

    /**
     * LogOut
     */
    public void doLogout() {
        this.userSession.doLogout();
    }

    /**
     * Gets the current User Session
     * @return UserSession
     */
    public UserSession getCurrentUserSession() {
        return this.userSession;
    }

    /**
     * Gets the Current User by it's UserSession
     * @return
     */
    public User getCurrentUserByUserSession() {
        return this.userSession.getUser();
    }

    /**
     * Changes the old Email to a new one
     * @param email
     * @param newEmail
     */
    public void changeEmailFromUserByLastEmail(String email, String newEmail) {
        this.users.changeEmailFromUserByLastEmail(email, newEmail);
    }

    /**
     * Gets the UserSession
     * @return
     */
    public UserSession getUserSession() {
        return userSession;
    }

    /**
     * Gets User to Send
     * @return User
     */
    public User getUserToSend() {
        return userToSend;
    }

}
