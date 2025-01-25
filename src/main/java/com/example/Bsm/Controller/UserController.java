package com.example.Bsm.Controller;

import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.UserResponse;
import com.example.Bsm.service.UserService;
import com.example.Bsm.util.ResponseStructure;
import com.example.Bsm.util.RestResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    public UserController(UserService userService, RestResponseBuilder responseBuilder) {
        this.userService = userService;
        this.responseBuilder = responseBuilder;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid UserRequest userRequest)
    {
       UserResponse userResponse = userService.registerUser(userRequest);

        return responseBuilder.success(HttpStatus.CREATED, "User created", userResponse);

    }
    @GetMapping("/users/{userId}")

    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId)
    {
        UserResponse userResponse = userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND, "User Found" , userResponse);

    }
    @PutMapping("/users/{userID}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @PathVariable int userID)
    {
        UserResponse userResponse = userService.updateUser(userRequest,userID);

        return responseBuilder.success(HttpStatus.CREATED, "User updated", userResponse);

    }


}

