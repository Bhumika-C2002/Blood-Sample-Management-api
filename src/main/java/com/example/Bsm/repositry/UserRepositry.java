package com.example.Bsm.repositry;

import com.example.Bsm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositry  extends JpaRepository<User, Integer>
{

    @Query("From User where userName = : userName")
     Optional<User> findByUserName(String userName);

      Optional<User> findByUserEmail(String userEmail);

}
