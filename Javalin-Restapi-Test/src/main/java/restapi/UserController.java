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

    public void listOne(Context context) {
        String userIdFromBrowser = context.pathParam("userId");
        Set<User> users = userService.users;
        for (User user : users) {
            if (userIdFromBrowser.equals(user.id())) {
                context.json(user);
                return;
            }
        }
        context.status(404).result("user not found");
    }

}
