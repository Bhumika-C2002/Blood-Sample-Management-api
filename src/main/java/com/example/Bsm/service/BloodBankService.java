package com.example.Bsm.service;

import com.example.Bsm.request.BloodBankRequest;
import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.BloodBankResponse;
import com.example.Bsm.response.UserResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BloodBankService {



    public BloodBankResponse insertBank(BloodBankRequest bloodBankRequest);
    //  User registerUser(User user);
    BloodBankResponse findBankById(int bloodBankId);

    BloodBankResponse updateBank(BloodBankRequest bloodBankRequest,  int bloodBankId);


}
