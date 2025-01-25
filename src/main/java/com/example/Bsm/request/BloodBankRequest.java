package com.example.Bsm.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BloodBankRequest {


    @NotNull(message = "BloodBank Name cannot be null")
    @NotBlank(message = "BloodBank Name cannot be blank")
    @Pattern(regexp = "$[A-Za-z_]^")

    private String bloodBankName;
    private int emergencyUnitCount;

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String bloodBankName) {
        this.bloodBankName = bloodBankName;
    }

    public int getEmergencyUnitCount() {
        return emergencyUnitCount;
    }

    public void setEmergencyUnitCount(int emergencyUnitCount) {
        this.emergencyUnitCount = emergencyUnitCount;
    }
}
