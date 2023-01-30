package com.gruchh.weather.Security.Config;

import com.gruchh.weather.Security.Entity.UserDB;
import com.gruchh.weather.Security.Repository.UserDBRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityConfig(UserDBRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserDBRepository userRepository;

    //REFACTOR
    @EventListener(ApplicationReadyEvent.class)
    public String a() {

        UserDB user = new UserDB("a@a.pl", getBcryptPasswordEncoder().encode("admin123"));
        userRepository.save(user);
        return "a";
    }

    @Bean
    public PasswordEncoder getBcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/h2-console").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }


}
