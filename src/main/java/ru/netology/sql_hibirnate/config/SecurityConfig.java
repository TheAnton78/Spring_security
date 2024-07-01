package ru.netology.sql_hibirnate.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig{

    @Bean
    InMemoryUserDetailsManager users() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("anton")
                .password("password")
                .roles("READ")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("gena")
                .password("password2")
                .roles("WRITE")
                .build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("petya")
                .password("passworddd")
                .roles("READ", "WRITE")
                .build();
        UserDetails user4 = User.withDefaultPasswordEncoder()
                .username("alena")
                .password("passworrd")
                .roles("READ", "DELETE")
                .build();
        return new InMemoryUserDetailsManager(user, user2, user3, user4);
    }
}



