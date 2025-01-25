package com.example.Bsm.serviceImpl;

import com.example.Bsm.entity.User;
import com.example.Bsm.enums.UserRole;
import com.example.Bsm.exception.UserNotFoundByIdException;
import com.example.Bsm.repositry.UserRepositry;
import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.UserResponse;
import com.example.Bsm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService
{
    @Autowired
    PasswordEncoder passwordEncoder;

    private final UserRepositry userRepositry;

    @Override
        public UserResponse registerUser(UserRequest userRequest)
    {
        // map data
        User user = mapToUserRequest(userRequest,new User());
        user.setUserRole(UserRole.USER);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        user = userRepositry.save(user);
        return maptoUserResponse(user);
    }

    //Factory Method to map userRequest to User
//    private  User mapToUser(UserRequest userRequest) {
//        return User.builder()
//                .userName(userRequest.getUserName())//use variable wr data stored
//                .userEmail(userRequest.getUserEmail())
//                .userPassword(userRequest.getUserPassword())
//                .userPhoneNo(userRequest.getUserPhoneNo())
//                .userBloodGroup(userRequest.getUserBloodGroup())
//                .Userage(userRequest.getUserage())
//                .Usergender(userRequest.getUsergender())
//                .userAvaliableCity(userRequest.getUserAvaliableCity())
//                .build();
//    }

    //Factory Method To Add or Update Mappings from User to UserRequest
    private User mapToUserRequest(UserRequest userRequest, User user)
    {
        user.setUserName(userRequest.getUserName());
        user.setUserEmail(userRequest.getUserEmail());
        user.setUserPassword(userRequest.getUserPassword());
        user.setUserage(userRequest.getUserage());
        user.setUserPhoneNo(userRequest.getUserPhoneNo());
        user.setUserAvaliableCity(userRequest.getUserAvaliableCity());
        user.setUserBloodGroup(userRequest.getUserBloodGroup());
        user.setUserLastDonated(userRequest.getUserLastDonated());
        return user;
    }

    //Factory Method for Mapping UserResponse from User
    private  UserResponse maptoUserResponse(User user) {
        return UserResponse.builder()
                .userID(user.getUserID())
                .userName(user.getUserName())
                .userage(user.getUserage())
                .userBloodGroup(user.getUserBloodGroup())
                .userAvaliableCity(user.getUserAvaliableCity())
                .userLastDonated(user.getUserLastDonated())
                .usergender(user.getUsergender())
                .userRole(user.getUserRole())
                .build();
    }


    //@Override
   public  UserResponse findUserById(int userId)
    {
        Optional<User> optional = userRepositry.findById(userId);

        if(optional.isEmpty())
            throw  new UserNotFoundByIdException("Failed to find User");
        User user = optional.get();
        return maptoUserResponse(user);
    }

    @Override
    public UserRequest update(int userId) {
        return null;
    }


    @Override
    public UserResponse updateUser(UserRequest userRequest, int userId) {
        Optional<User> optional = userRepositry.findById(userId);

        if(optional.isEmpty())
            throw  new UserNotFoundByIdException("Failed to find User");
        User existingUser = optional.get();
          existingUser= mapToUserRequest(userRequest,existingUser);
          userRepositry.save(existingUser);
        return maptoUserResponse(existingUser);
           }

}
