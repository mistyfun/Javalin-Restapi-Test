package restapi;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.Set;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void listAll(Context context) {
        Set<User> users = userService.getAllUsers();
        context.json(users);
    }

    public void listOne(Context context) {
        String userIdFromBrowser = context.pathParam("userId");
        User user = userService.getUserById(userIdFromBrowser);
        if (user != null) {
            context.json(user);
        } else {
            context.status(404).result("user not found");
        }

    }

    public void create(Context context) {
        User user = context.bodyValidator(User.class).get(); // will throw if the request body is not valid
        if (userService.addUser(user)) {
            context.status(201);
        } else {
            context.status(400);
        }
    }

    public void update(Context context) {
        String userIdFromBrowser = context.pathParam("userId");
        if (userService.getUserById(userIdFromBrowser) == null) {
            context.status(404);
        } else {
            User user = context.bodyValidator(User.class).get(); // will throw if the request body is not valid
            if (userService.updateUser(userIdFromBrowser, user.name(), user.email())) {
                context.status(204);
            } else {
                context.status(400);
            }
        }
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
