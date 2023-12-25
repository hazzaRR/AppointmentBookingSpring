package com.hazr.AppointmentBooking.service;

import com.hazr.AppointmentBooking.dto.LoginResponseDTO;
import com.hazr.AppointmentBooking.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@Transactional
public class AuthenticationService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public LoginResponseDTO loginUser(String username, String password) throws LoginException {

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            LoginResponseDTO userDetails;

            userDetails = new LoginResponseDTO(username, token);

            return userDetails;

        } catch(AuthenticationException e) {
            System.out.println(e);

            throw new LoginException("incorrect login details");
        }
    }
}
