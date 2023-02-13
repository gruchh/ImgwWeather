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
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {

    private UserDBRepository userRepository;
    private JwtTokenFilter jwtTokenFilter;

    public SecurityConfig(UserDBRepository userRepository, JwtTokenFilter jwtTokenFilter) {
        this.userRepository = userRepository;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    //REFACTOR
    @EventListener(ApplicationReadyEvent.class)
    public void prepareSampleUsers() {

        UserDB user = new UserDB("a@a.pl", getBcryptPasswordEncoder().encode("admin123"), "ROLE_USER");
        userRepository.save(user);
        UserDB user2 = new UserDB("b@b.pl", getBcryptPasswordEncoder().encode("bbbxax"), "ROLE_ADMIN");
        userRepository.save(user2);
        System.out.println("User " + user);
        System.out.println("User2 " + user2);
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
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http.csrf().disable();
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        MvcRequestMatcher h2RequestMatcher = new MvcRequestMatcher(introspector, "/**");
        h2RequestMatcher.setServletPath("/h2-console");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(h2RequestMatcher).permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/getSampleWaterMeasures").permitAll()
                        .requestMatchers("/rivers/test").permitAll()
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
