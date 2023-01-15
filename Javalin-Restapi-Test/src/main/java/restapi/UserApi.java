package restapi;

import io.javalin.Javalin;

public class UserApi {
    public static void main(String[] args) {
        UserService userService = new UserService() ;
        UserController userController = new UserController(userService);
        var app = Javalin.create(/*config*/)
                .post("/users", userController::create) //no id
                .get("/users", userController::listAll)
                .get("/users/{userId}", userController::listOne)
                .patch("/users/{userId}", userController::update) //give the id to the server
                .delete("/users/{userId}", userController::delete) //give the id to the server
                .start(7070);
    }
}
