package com.example.Bsm.request;

import com.example.Bsm.enums.BloodGroup;
import com.example.Bsm.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class UserRequest {

   @NotNull(message = "username cannot be null")
   @NotBlank(message = "username cannot be blank")
   @Pattern(regexp = "$[A-Za-z_]^")
    private String userName;


    private String userEmail;

    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password cannot be blank")
   // @Pattern(regexp =
    private String userPassword;
    private String userPhoneNo;
    private BloodGroup userBloodGroup;
    private int userage;
    private LocalDate userLastDonated;
    private Gender usergender;
    private String userAvaliableCity;


    public LocalDate getUserLastDonated() {
        return userLastDonated;
    }

    public void setUserLastDonated(LocalDate userLastDonated) {
        this.userLastDonated = userLastDonated;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public BloodGroup getUserBloodGroup() {
        return userBloodGroup;
    }

    public void setUserBloodGroup(BloodGroup userBloodGroup) {
        this.userBloodGroup = userBloodGroup;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        userage = userage;
    }

    public Gender getUsergender() {
        return usergender;
    }

    public void setUsergender(Gender usergender) {
        usergender = usergender;
    }

    public String getUserAvaliableCity() {
        return userAvaliableCity;
    }

    public void setUserAvaliableCity(String userAvaliableCity) {
        this.userAvaliableCity = userAvaliableCity;
    }
}
