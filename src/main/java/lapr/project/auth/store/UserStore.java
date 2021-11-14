package lapr.project.auth.store;

import lapr.project.auth.Email;
import lapr.project.auth.Password;
import lapr.project.auth.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserStore {
    private final Set<User> store = new HashSet<>();

    public User create(String name, String email, String password) {
        return new User(new Email(email), new Password(password), name);
    }

    public boolean add(User user) {
        if (user != null && !exists(user)) {
                return this.store.add(user);
        }
        return false;
    }

    public Optional<User> getById(String email) {
        return this.getById(new Email(email));
    }

    public Optional<User> getById(Email email) {
        for (User user : this.store) {
            if (user.hasId(email))
                return Optional.of(user);
        }
        return Optional.empty();
    }

    public boolean exists(String email) {
        Optional<User> result = getById(email);
        return result.isPresent();
    }

    public boolean exists(Email email) {
        Optional<User> result = getById(email);
        return result.isPresent();
    }

    public boolean exists(User user) {
        return this.store.contains(user);
    }

    public void changeEmailFromUserByLastEmail(String email, String newEmail) {
        for (User user : store) {
            if ((user.getId().getMail()).equalsIgnoreCase(email)) {
                user.getId().setMail(newEmail);
            }
        }
    }
}
