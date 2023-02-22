# User API Demo Javalin

This is a simple REST API demo that allows you to create, read, update, and delete user data. It is built using [Javalin](https://javalin.io/), a lightweight web framework for Java.

## Files

The project has the following files:

- `src/main/java/org/example/User.java`: The data model that represents a user.
- `src/main/java/org/example/UserApi.java`: The main file that sets up the Javalin server and defines the API routes.
- `src/main/java/org/example/UserController.java`: The controller that handles user requests and interacts with the `UserService.java` file.
- `src/main/java/org/example/UserService.java`: The service that provides CRUD (Create, Read, Update, Delete) operations for the user data.

## API Endpoints

The API provides the following endpoints:

- `GET /users`: Get all users.
- `GET /users/:id`: Get a user by ID.
- `POST /users`: Create a new user.
- `PATCH /users/:id`: Update an existing user.
- `DELETE /users/:id`: Delete a user by ID.

