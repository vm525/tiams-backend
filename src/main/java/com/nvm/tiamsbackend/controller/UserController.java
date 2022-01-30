package com.nvm.tiamsbackend.controller;

import com.nvm.tiamsbackend.common.TransformEntityToDto;
import com.nvm.tiamsbackend.dtos.UserDto;
import com.nvm.tiamsbackend.entity.User;
import com.nvm.tiamsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final String DEFAULT_ROLE = "ROLE_USER";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String userSignUp(@RequestBody User user) {
        user.setRoles(DEFAULT_ROLE);
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "User: " + user.getUserEmail() + ", successfully signed up!";
    }


//    @GetMapping("/login")
//    public UserDto userLogin() throws Exception {
//        Optional<User> userPot = userRepository.findByUserEmail(email);
//        boolean isPasswordMatched = false;
//        if(userPot.isPresent())
//            isPasswordMatched = passwordEncoder.matches(pass, userPot.get().getPassword());
//        if(isPasswordMatched) {
//            return TransformEntityToDto.transformUserEntityToDto(userPot.get());
//        } else {
//            throw new Exception("invalid email/password combination!");
//        }
//    }

}
