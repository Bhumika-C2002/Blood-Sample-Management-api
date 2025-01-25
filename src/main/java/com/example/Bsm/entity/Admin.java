package com.example.Bsm.entity;

import com.example.Bsm.enums.AdminType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Admin
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
   private AdminType adminType;

    public AdminType getAdminType()
    {
        return adminType;
    }

    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }

    @OneToOne
    private User user;




    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User get() {
        return null;
    }

    public boolean isEmpty() {
    return false;}
}
