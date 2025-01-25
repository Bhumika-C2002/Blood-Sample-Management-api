package com.example.Bsm.entity;

import com.example.Bsm.enums.BloodGroup;
import com.example.Bsm.enums.Gender;
import com.example.Bsm.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPhoneNo;
    private BloodGroup userBloodGroup;
    private LocalDate userLastDonated;
    private int userage;
    private Gender usergender;
    private String userAvaliableCity;
    private boolean userVerifed;
    private UserRole userRole;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Admin admin;




//    {
//        "userName":"Bhumi",
//            "userEmail":"bh@gmail.com",
//            "userPassword":"bh254",
//            "userPhoneNo":"9854214894",
//            "userBloodGroup":"O_Positive",
//            "userLastDonated":"2025-01-22",
//            "Userage":22,
//            "Usergender":"Female",
//            "userAvaliableCity":"Cta",
//            "userVerifed":"true"
//    }






}
