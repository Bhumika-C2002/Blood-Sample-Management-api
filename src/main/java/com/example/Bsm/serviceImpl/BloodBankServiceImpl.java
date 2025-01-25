package com.example.Bsm.serviceImpl;

import com.example.Bsm.entity.BloodBank;
import com.example.Bsm.entity.User;
import com.example.Bsm.exception.BloodBankNotFoundByIdException;
import com.example.Bsm.repositry.BloodBankRepositry;
import com.example.Bsm.request.BloodBankRequest;
import com.example.Bsm.response.BloodBankResponse;
import com.example.Bsm.service.BloodBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class BloodBankServiceImpl  implements BloodBankService {

     private final BloodBankRepositry bloodBankRepositry;

        @Override
        public BloodBankResponse insertBank(BloodBankRequest bloodBankRequest)
        {
            BloodBank bloodBank = mapToBloodBankRequest( bloodBankRequest, new BloodBank());
            bloodBank = bloodBankRepositry.save(bloodBank);

            return maptoBloodBankResponse(bloodBank);
        }

    @Override
    public BloodBankResponse findBankById(int bloodBankId) {
        return null;
    }


    private BloodBank mapToBloodBankRequest(BloodBankRequest bloodBankRequest, BloodBank bloodBank)
        {
            bloodBank.setBloodBankName(bloodBank.getBloodBankName());

            return bloodBank;
        }


        private  BloodBankResponse maptoBloodBankResponse(BloodBank bloodBank) {
            return BloodBankResponse.builder()
                    .bloodBankID(bloodBank.getBloodBankID())
                    .bloodBankName(bloodBank.getBloodBankName())
                    .build();
        }


        //@Override
        public  BloodBankResponse findBloodBankById(int bloodBankId)
        {
            Optional<BloodBank> optional = bloodBankRepositry.findById(bloodBankId);

            if(optional.isEmpty())
                throw  new BloodBankNotFoundByIdException("Failed to find BloodBank");
            BloodBank bloodBank = optional.get();
            return maptoBloodBankResponse(bloodBank);
        }


        public BloodBankRequest updateBank(int bloodBankId) {
            return null;
        }


        @Override
        public BloodBankResponse updateBank(BloodBankRequest bloodBankRequest, int bloodBankId) {
            Optional<BloodBank> optional = bloodBankRepositry.findById(bloodBankId);

            if(optional.isEmpty())
                throw  new BloodBankNotFoundByIdException("Failed to find User");
            BloodBank existingBloodBank = optional.get();
            existingBloodBank= mapToBloodBankRequest(bloodBankRequest,existingBloodBank);
            bloodBankRepositry.save(existingBloodBank);
            return maptoBloodBankResponse(existingBloodBank);
        }

    }



