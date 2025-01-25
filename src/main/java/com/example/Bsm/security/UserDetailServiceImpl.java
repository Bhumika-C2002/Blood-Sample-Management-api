package com.example.Bsm.security;

import com.example.Bsm.entity.User;
import com.example.Bsm.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private  final UserRepositry userRepositry;

    public UserDetailServiceImpl(UserRepositry userRepositry) {
        this.userRepositry = userRepositry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepositry.findByUserEmail("bhu@gmial.com");
        if(user.isEmpty())
            throw new UsernameNotFoundException("failed to authenticate user");
        User user1 = user.get();


        return (UserDetails) User.builder()
                .userName(user.get().getUserEmail())
                .userPassword(user.get().getUserPassword())
                .build();
    }
}
