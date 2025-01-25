package com.example.Bsm.serviceImpl;

import com.example.Bsm.entity.Hospital;
import com.example.Bsm.exception.HospitalNotFoundByIdException;
import com.example.Bsm.repositry.HospitalRepositry;
import com.example.Bsm.request.HospitalRequest;
import com.example.Bsm.response.HospitalResponse;
import com.example.Bsm.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;





@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService 
{
    private final HospitalRepositry hospitalRepositry;

    @Override
    public HospitalResponse addHospital(HospitalRequest hospitalRequest) {

        Hospital hospital = mapToHospitalRequest(hospitalRequest, new Hospital());
        hospital = hospitalRepositry.save(hospital);
        return  mapToHospitalResponse(hospital);
    }
    
    private Hospital mapToHospitalRequest(HospitalRequest hospitalRequest ,Hospital hospital) 
    {
        hospital.setHospitalName(hospitalRequest.getHospitalName());
        return hospital;
    }
    
    private HospitalResponse mapToHospitalResponse(Hospital hospital) {
        return HospitalResponse.builder()
                .hospitalId(hospital.getHospitalId())
                .hospitalName(hospital.getHospitalName())
                .build();
    }

    @Override
    public HospitalResponse findHospitalById(int hospitalId) {
        Optional<Hospital> optional = hospitalRepositry.findById(hospitalId);

        if(optional.isEmpty())
            throw  new HospitalNotFoundByIdException("Failed to find hospital");
        Hospital hospital = optional.get();
        return mapToHospitalResponse(hospital);
    }

    
    @Override
    public HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId) {
        Optional<Hospital> optional = hospitalRepositry.findById(hospitalId);

        if(optional.isEmpty())
            throw  new HospitalNotFoundByIdException("Failed to find Hospital");
        Hospital existingHospital = optional.get();
        existingHospital= mapToHospitalRequest(hospitalRequest,existingHospital);
        hospitalRepositry.save(existingHospital);
        return mapToHospitalResponse(existingHospital);  
    }
}


        