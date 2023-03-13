package com.gruchh.weather.Security.Config;

import com.gruchh.weather.Security.Entity.UserDB;
import com.gruchh.weather.Security.JwtTokenFilter;
import com.gruchh.weather.Security.Repository.UserDBRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {

    private static final String API_SUFIX = "/api/v1/";
    private UserDBRepository userRepository;
    private JwtTokenFilter jwtTokenFilter;

    public SecurityConfig(UserDBRepository userRepository, JwtTokenFilter jwtTokenFilter) {
        this.userRepository = userRepository;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    // Add 2 users at start
    @EventListener(ApplicationReadyEvent.class)
    public void prepareSampleUsers() {

        UserDB user = new UserDB("a@a.pl", getBcryptPasswordEncoder().encode("admin123"), "ROLE_USER");
        userRepository.save(user);
        UserDB user2 = new UserDB("b@b.pl", getBcryptPasswordEncoder().encode("bbbxax"), "ROLE_ADMIN");
        userRepository.save(user2);
        System.out.println("User " + user);
        System.out.println("User2 " + user2);
    }

    private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {

            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/auth/login"),
            new AntPathRequestMatcher("/getSampleWaterMeasures"),
            new AntPathRequestMatcher(API_SUFIX + "/rivers/**"),
    };

    @Bean
    public PasswordEncoder getBcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(WHITE_LIST_URLS).permitAll()
                .requestMatchers("/hello").hasRole("ADMIN")
                .anyRequest().authenticated()
                );
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}