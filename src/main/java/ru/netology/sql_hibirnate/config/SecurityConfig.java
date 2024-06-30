package ru.netology.sql_hibirnate.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{



    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests.requestMatchers("/persons/by-id").permitAll()
                        .requestMatchers("/persons/less-age").hasAuthority("write")
                        .requestMatchers("/persons/by-name-surname").hasAuthority("read")
                        .requestMatchers("/persons/by-city").hasAnyAuthority("read", "write"))
                .formLogin(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    InMemoryUserDetailsManager users() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("anton")
                .password("password")
                .authorities("read","write")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("gena")
                .password("password2")
                .authorities("read").build();
        return new InMemoryUserDetailsManager(user, user2);
    }
}



