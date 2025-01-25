package com.example.Bsm.Controller;

import com.example.Bsm.entity.User;
import com.example.Bsm.repositry.AdminRepositry;
import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.UserResponse;
import com.example.Bsm.service.AdminService;
import com.example.Bsm.util.ResponseStructure;
import com.example.Bsm.util.RestResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController
{
    private  final AdminService adminService;
    private  final RestResponseBuilder responseBuilder;

    public AdminController(AdminService adminService, RestResponseBuilder responseBuilder) {
        this.adminService = adminService;
        this.responseBuilder = responseBuilder;
    }

    @PutMapping("/admin/{userID}")
    public ResponseEntity<ResponseStructure<UserResponse>> adminFound(@RequestBody  UserRequest userRequest, @PathVariable int userID){
        UserResponse userResponse = adminService.adminFound(userRequest,userID);
        return responseBuilder.success(HttpStatus.CREATED, "Creted" ,userResponse);
    }


    @PostMapping("/admin")
    public ResponseEntity<ResponseStructure<UserResponse>> addAdminUsers(@RequestBody  UserRequest userRequest){
        UserResponse userResponse = adminService.addAdminUsers(UserRequest);
        return responseBuilder.success(HttpStatus.CREATED, "Creted" ,userResponse);

    }

}
