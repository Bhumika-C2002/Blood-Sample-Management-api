package com.example.Bsm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.beans.Customizer;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){

     return    http.csrf(csrf->csrf.disble())
             .authorizeHttpRequest(authorize ->
                     authorize.requestMatchers("/register","/blood-bank")
                             .permitAll()
                             .anyRequest()
                             .authenticated()
             )
             .formlogin(Customizer.withDefaults())
             .build();



    }
}
