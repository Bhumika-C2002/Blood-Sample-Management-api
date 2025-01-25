package com.example.Bsm.serviceImpl;

import com.example.Bsm.entity.Admin;
import com.example.Bsm.entity.User;
import com.example.Bsm.enums.AdminType;
import com.example.Bsm.enums.UserRole;
import com.example.Bsm.exception.UserNotFoundByIdException;
import com.example.Bsm.repositry.AdminRepositry;
import com.example.Bsm.repositry.UserRepositry;
import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.UserResponse;
import com.example.Bsm.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {
private UserRepositry userRepositry;
private AdminRepositry adminRepositry;

    public AdminServiceImpl(AdminRepositry adminRepositry , UserRepositry userRepositry) {
        this.adminRepositry = adminRepositry;
        this.userRepositry = userRepositry;
    }


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



    @Override
    public UserResponse adminFound(UserRequest userRequest, int userID)
    {

        Optional<User> optional = userRepositry.findById(userID);

        if (optional.isEmpty())
            throw  new UserNotFoundByIdException("Failed to find User");

        User promoteUser = optional.get();
        promoteUser.setUserRole(UserRole.ADMIN);

        promoteUser =mapToUserRequest(userRequest,promoteUser);

        userRepositry.save(promoteUser);

        Admin admin=Admin.builder().user(promoteUser).build();

        adminRepositry.save(admin);

        return maptoUserResponse(promoteUser);

    }

    private UserResponse maptoUserResponse(User user) {

        return UserResponse.builder()
                .userID(user.getUserID())
                .userName(user.getUserName())
                .userLastDonated(user.getUserLastDonated())
                .usergender(user.getUsergender())
                .userAvaliableCity(user.getUserAvaliableCity())
                .userBloodGroup(user.getUserBloodGroup())
                .userRole(user.getUserRole())
                .build();
    }

    @Override
    public UserResponse addAdminUsers(UserRequest userRequest){

        User user = mapToUserRequest(userRequest,new User());
        user.setUserRole(UserRole.ADMIN);
        userRepositry.save(user);

        Admin admin = Admin.builder()
                .adminType(AdminType.Owner)
                .user(user)
                .build();
        adminRepositry.save(admin);
        return maptoUserResponse(user);

    }


}



