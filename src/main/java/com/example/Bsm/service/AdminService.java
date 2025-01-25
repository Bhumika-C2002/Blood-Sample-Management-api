package com.example.Bsm.service;

import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.UserResponse;

public interface AdminService {



   public UserResponse adminFound(UserRequest userRequest, int userID);
   public UserResponse addAdminUsers(UserRequest userRequest);

}
