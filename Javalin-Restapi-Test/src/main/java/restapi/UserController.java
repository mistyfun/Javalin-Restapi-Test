package restapi;

import io.javalin.http.Context;

import java.util.Set;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void listAll(Context context) {
        Set<User> users = userService.users;
        context.json(users);
    }

}
