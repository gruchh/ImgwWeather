package com.gruchh.weather.Security.Api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.gruchh.weather.Security.AuthRequest;
import com.gruchh.weather.Security.AuthResponse;
import com.gruchh.weather.Security.Entity.UserDB;
import com.gruchh.weather.Security.Repository.UserDBRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    AuthenticationManager authenticationManager;

    public UserApi(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/auth/login")
    public ResponseEntity getJWT(@RequestBody AuthRequest authRequest) {

        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

            UserDB userDB = (UserDB) authenticate.getPrincipal();

            Algorithm algorithm = Algorithm.HMAC256("SECRET");
            String token = JWT.create()
                    .withSubject(userDB.getUsername())
                    .withIssuer("gruchh")
                    .withClaim("isAdmin", true)
                    .sign(algorithm);

            AuthResponse authResponse = new AuthResponse(userDB.getPassword(), token);
            return ResponseEntity.ok(authResponse);
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
