package com.example.Bsm.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class HospitalRequest {

    @NotNull(message = "Hospital Name cannot be null")
    @NotBlank(message = "Hospital Name cannot be blank")
    @Pattern(regexp =  "$[A-Za-Z_]^")
    private String hospitalName;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
