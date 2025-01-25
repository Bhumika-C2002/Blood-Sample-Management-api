package com.example.Bsm.service;

import com.example.Bsm.entity.User;
import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.UserResponse;

public interface UserService
{
    public UserResponse registerUser(UserRequest userRequest);
   //  User registerUser(User user);
    UserResponse findUserById(int userId);

    UserRequest update(int userId);

    UserResponse updateUser(UserRequest userRequest, int userId);
}
