package restapi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {

    private final Set<User> users = new HashSet<>(
            List.of(
                    new User("1", "Sandy", "0987654321@email.com"),
                    new User("2", "Tom", "1122334455@email.com"),
                    new User("3", "Jerry", "12345@email.com")
            )
    );

    public Set<User> getAllUsers() {
        return users;
    }

    public User getUserById(String userId) {
        for (User user : users) {
            if (userId.equals(user.id())) {
                return user;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public boolean updateUser(String id, String name, String email) {
        if (name == null || email == null) return false;
        removeUser(id);
        return addUser(new User(id, name, email));
    }

    public boolean removeUser(String userId) {
        return users.removeIf(user -> user.id().equals(userId));
    }

}
