package com.example.Bsm.repositry;

import com.example.Bsm.entity.BloodBank;
import com.example.Bsm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepositry extends JpaRepository<BloodBank, Integer> {
}
