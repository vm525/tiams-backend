package com.nvm.tiamsbackend.controller;

import com.nvm.tiamsbackend.common.JwtUtil;
import com.nvm.tiamsbackend.common.TransformEntityToDto;
import com.nvm.tiamsbackend.common.Utils;
import com.nvm.tiamsbackend.dtos.AuthRequestDto;
import com.nvm.tiamsbackend.dtos.UserDto;
import com.nvm.tiamsbackend.entity.User;
import com.nvm.tiamsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Optional;

@RestController
public class UserController {

    private final String DEFAULT_ROLE = "ROLE_USER";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/signup")
    public ResponseEntity<String> userSignUp(@RequestBody User user) {
        Optional<User> userPresent = userRepository.findByUserEmail(user.getUserEmail());
        if(!userPresent.isPresent()) {
            user.setRoles(DEFAULT_ROLE);
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User: " + user.getUserName() + ", successfully signed up!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email id already present in the system!");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody AuthRequestDto authRequestDto) {
        Optional<User> userPot = userRepository.findByUserEmail(authRequestDto.getUserEmail());
        boolean isPasswordMatched = false;
        if(userPot.isPresent())
            isPasswordMatched = passwordEncoder.matches(authRequestDto.getPassword(), userPot.get().getPassword());
        if (isPasswordMatched) {
            String payload = TransformEntityToDto.transformUserEntityToJson(userPot.get());
            return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateToken(payload));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid email/password combination!");
        }
    }

}
