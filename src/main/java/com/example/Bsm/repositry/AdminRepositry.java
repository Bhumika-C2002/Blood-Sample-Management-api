package com.example.Bsm.repositry;

import com.example.Bsm.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositry  extends JpaRepository<Admin, Integer> {

    //Admin findById(int userId);


}
