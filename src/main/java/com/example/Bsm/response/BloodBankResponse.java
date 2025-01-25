package com.example.Bsm.response;

import com.example.Bsm.enums.BloodGroup;
import com.example.Bsm.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BloodBankResponse {

    private int bloodBankID;
    private String bloodBankName;
    private int emergencyUnitCount;

    public int getBloodBankID() {
        return bloodBankID;
    }

    public void setBloodBankID(int bloodBankID) {
        this.bloodBankID = bloodBankID;
    }

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