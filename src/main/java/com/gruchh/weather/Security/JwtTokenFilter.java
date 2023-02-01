package com.gruchh.weather.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if (authorization == null) {
            filterChain.doFilter(request, response);
            return;
        }
        parseJwt(authorization);

    }

    public String parseJwt(String token) {
        String role = "ROLE_USER";

        Algorithm algorithm = Algorithm.HMAC256("SECRET");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("gruchh")
                .build();

        String subtoken = token.substring(7);
        DecodedJWT decodedJWT = verifier.verify(subtoken);
        Boolean isAdmin = decodedJWT.getClaim("isAdmin").asBoolean();

        if ( isAdmin ) {
            role = "ROLE_ADMIN";
        }

   //     SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);

        return null;
    }
}
