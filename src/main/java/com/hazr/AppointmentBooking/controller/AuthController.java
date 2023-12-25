package com.hazr.AppointmentBooking.controller;

import com.hazr.AppointmentBooking.dto.LoginDTO;
import com.hazr.AppointmentBooking.dto.LoginResponseDTO;
import com.hazr.AppointmentBooking.service.AuthenticationService;
import com.hazr.AppointmentBooking.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final TokenService tokenService;


    public AuthController(AuthenticationService authenticationService, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginDTO body) throws LoginException {

        System.out.println(body.toString());

        LoginResponseDTO loginResponse = authenticationService.loginUser(body.getUsername(), body.getPassword());


        return ResponseEntity.ok(loginResponse);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<String> handleAuthenticationException(LoginException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }
}
