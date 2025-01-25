package com.example.Bsm.service;

import com.example.Bsm.request.HospitalRequest;
import com.example.Bsm.response.HospitalResponse;


public interface HospitalService
{
    public  HospitalResponse addHospital(HospitalRequest hospitalRequest);


    HospitalResponse findHospitalById(int hospitalId );

    HospitalResponse updateHospital( HospitalRequest hospitalRequest,  int hospitalId);

}
