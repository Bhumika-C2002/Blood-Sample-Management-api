package com.example.Bsm.Controller;

import com.example.Bsm.request.HospitalRequest;
import com.example.Bsm.response.HospitalResponse;
import com.example.Bsm.service.HospitalService;
import com.example.Bsm.util.ResponseStructure;
import com.example.Bsm.util.RestResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class HospitalController {
    private final HospitalService hospitalService;
    private  final RestResponseBuilder responseBuilder;

    public HospitalController(HospitalService hospitalService, RestResponseBuilder responseBuilder )
    {
        this.hospitalService = hospitalService;
        this.responseBuilder = responseBuilder;

    }

    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<HospitalResponse>> addHospital(@RequestBody  HospitalRequest hospitalRequest)
    {
        HospitalResponse hospitalResponse = hospitalService.addHospital(hospitalRequest);

        return responseBuilder.success(HttpStatus.CREATED,  "Hospital created",hospitalResponse);
    }

    @GetMapping("/hospital/{hospitalId}")

    public ResponseEntity<ResponseStructure<HospitalResponse>> findHospitalById(@PathVariable int hospitalId )
    {
        HospitalResponse hospitalResponse = hospitalService.findHospitalById(hospitalId);
        return responseBuilder.success(HttpStatus.FOUND, "Hospital Found" , hospitalResponse);

    }


    @PutMapping("/hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> updateHospital(@RequestBody HospitalRequest hospitalRequest, @PathVariable int hospitalId)
    {
        HospitalResponse hospitalResponse = hospitalService.updateHospital(hospitalRequest,hospitalId);

        return responseBuilder.success(HttpStatus.CREATED, "Hospital updated", hospitalResponse);

    }

}
