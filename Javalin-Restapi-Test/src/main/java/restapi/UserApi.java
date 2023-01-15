package restapi;

import io.javalin.Javalin;

public class UserApi {
    public static void main(String[] args) {
        UserService userService = new UserService() ;
        UserController userController = new UserController(userService);
        var app = Javalin.create(/*config*/)
                .get("/users", userController::listAll)
                .start(7070);
    }
}
