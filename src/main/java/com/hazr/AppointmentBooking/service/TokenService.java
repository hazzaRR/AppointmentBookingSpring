package com.hazr.AppointmentBooking.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final JwtEncoder jwtEncoder;

    private final JwtDecoder jwtDecoder;

    public TokenService (JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
        this.jwtEncoder = jwtEncoder;
    }

    public String generateJwt(Authentication auth) {

        Instant now = Instant.now();

        List<String> scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        System.out.println(scope);
        System.out.println(now.plus(1, ChronoUnit.DAYS));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .subject(auth.getName())
                .claim("roles", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();


    }

}
