package com.gruchh.weather.Security.Api;

import com.gruchh.weather.Security.AuthRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    AuthenticationManager authenticationManager;

    @PostMapping ("/auth/login")
    public String getJWT(@RequestBody AuthRequest authRequest) {
        AuthenticationManager authenticationManager;

        return "";
    }
}
