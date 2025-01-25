package com.example.Bsm.response;

import com.example.Bsm.enums.BloodGroup;
import com.example.Bsm.enums.Gender;
import com.example.Bsm.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int userID;
    private String userName;
    private BloodGroup userBloodGroup;
    private LocalDate userLastDonated;
    private int userage;
    private Gender usergender;
    private String userAvaliableCity;
    private UserRole userRole;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BloodGroup getUserBloodGroup() {
        return userBloodGroup;
    }

    public void setUserBloodGroup(BloodGroup userBloodGroup) {
        this.userBloodGroup = userBloodGroup;
    }

    public LocalDate getUserLastDonated() {
        return userLastDonated;
    }

    public void setUserLastDonated(LocalDate userLastDonated) {
        this.userLastDonated = userLastDonated;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public Gender getUsergender() {
        return usergender;
    }

    public void setUsergender(Gender usergender) {
        this.usergender = usergender;
    }

    public String getUserAvaliableCity() {
        return userAvaliableCity;
    }

    public void setUserAvaliableCity(String userAvaliableCity) {
        this.userAvaliableCity = userAvaliableCity;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
