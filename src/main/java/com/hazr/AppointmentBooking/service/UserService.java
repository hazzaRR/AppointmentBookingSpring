package com.hazr.AppointmentBooking.service;

import com.hazr.AppointmentBooking.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username is not valid"));
    }



//    @Transactional
//    public void updatePassword(UpdatePasswordDTO updatePasswordDTO) {
//
//        Optional<User> user = userRepository.findByUsername(updatePasswordDTO.getUsername());
//
//        if (user.isEmpty()) {
//            throw new UsernameDoesNotExistException("the username " + updatePasswordDTO.getUsername() + " does not exist");
//        }
//
//        User loggedInUser = user.get();
//
//        if(!passwordEncoder.matches(updatePasswordDTO.getPassword(), loggedInUser.getPassword())) {
//            throw new IncorrectPasswordException("password provided is incorrect");
//        }
//
//        String encryptedPassword =  passwordEncoder.encode(updatePasswordDTO.getNewPassword());
//
//        loggedInUser.setPassword(encryptedPassword);
//    }
}
