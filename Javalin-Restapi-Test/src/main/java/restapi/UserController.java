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
        User user = userService.getUser(userIdFromBrowser);
        if (user != null) {
            context.json(user);
        } else {
            context.status(404).result("user not found");
        }

    }

    public void create(Context context) {

    }

    public void update(Context context) {

    }

    public void delete(Context context) {
        String userIdFromBrowser = context.pathParam("userId");
        boolean deleted = userService.removeUser(userIdFromBrowser);
        if (deleted) {
            context.status(204);
        } else {
            context.status(404).result("user not found");
        }

    }

}
