package lapr.project.auth.store;

import lapr.project.auth.UserRole;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRoleStore {

    private final Set<UserRole> store = new HashSet<>();

    public UserRole create(String id, String description) {
        return new UserRole(id, description);
    }

    public boolean validateRole(UserRole role) {
        if (role == null) {
            return false;
        }
        return !this.exists(role);
    }

    public boolean add(UserRole role) {
        if (role != null && !exists(role)) {
            return this.store.add(role);
        }
        return false;
    }

    public boolean remove(UserRole role) {
        if (role != null)
            return this.store.remove(role);
        return false;
    }

    public Optional<UserRole> getById(String id) {
        for (UserRole role : this.store) {
            if (role.hasId(id))
                return Optional.of(role);
        }
        return Optional.empty();
    }

    public boolean exists(String id) {
        Optional<UserRole> result = getById(id);
        return result.isPresent();
    }

    public boolean exists(UserRole role) {
        return this.store.contains(role);
    }
}
