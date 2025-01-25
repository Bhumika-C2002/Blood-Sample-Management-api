package com.example.Bsm.Controller;


import com.example.Bsm.request.BloodBankRequest;
import com.example.Bsm.request.UserRequest;
import com.example.Bsm.response.BloodBankResponse;
import com.example.Bsm.response.UserResponse;
import com.example.Bsm.service.BloodBankService;
import com.example.Bsm.service.UserService;
import com.example.Bsm.util.ResponseStructure;
import com.example.Bsm.util.RestResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BloodBankController {
    private final BloodBankService bloodBankService;
    private final RestResponseBuilder responseBuilder;

    public BloodBankController(BloodBankService bloodBankService, RestResponseBuilder responseBuilder) {
        this.bloodBankService = bloodBankService;
        this.responseBuilder = responseBuilder;
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> insertBank(@RequestBody  BloodBankRequest bloodBankRequest,@PathVariable int adminId)
    {
        BloodBankResponse bloodBankResponse = bloodBankService.insertBank(bloodBankRequest,adminId);

        return responseBuilder.success(HttpStatus.CREATED, "Blood bank  created", bloodBankResponse);

    }
    @GetMapping("/blood/{bloodBankId}")

    public ResponseEntity<ResponseStructure<BloodBankResponse>> findBankById(@PathVariable int bloodBankId)
    {
        BloodBankResponse bloodBankResponse = bloodBankService.findBankById(bloodBankId);
        return responseBuilder.success(HttpStatus.FOUND, "bank id Found" , bloodBankResponse);

    }
    @PutMapping("/bank/{bloodBankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> updateBank(@RequestBody BloodBankRequest bloodBankRequest, @PathVariable int bloodBankId)
    {
        BloodBankResponse bloodBankResponse = bloodBankService.updateBank(bloodBankRequest,bloodBankId);

       return responseBuilder.success(HttpStatus.CREATED, "User created", bloodBankResponse);

    }

    @GetMapping("/blood-banks")
    public  ResponseEntity<ResponseStructure<<List>BloodBankResponse>>> finadAllBloodBank(){
        List<BloodBankResponse> bloodBankResponse = bloodBankService.finadAllBloodBank();
        return responseBuilder.success(HttpStatus.CREATED, "User created", bloodBankResponse);;
    }


}


