package com.gruchh.weather.Security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private String email;
    private String token;

    public AuthResponse(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
