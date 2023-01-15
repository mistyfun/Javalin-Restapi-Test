package restapi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {

    public Set<User> users = new HashSet<>(
            List.of(
                    new User("1", "Sandy", "0987654321@email.com"),
                    new User("2", "Tom", "1122334455@email.com"),
                    new User("3", "Jerry", "12345@email.com")
            )
    );

}
