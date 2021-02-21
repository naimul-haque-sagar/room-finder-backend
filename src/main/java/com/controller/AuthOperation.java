package com.controller;

import com.dto.AuthenticationResponse;
import com.dto.LoginRequest;
import com.dto.SignUpRequest;
import com.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthOperation{
    private AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@Valid @RequestBody SignUpRequest signUpRequest){
        if(authService.ifUserExists(signUpRequest.getUserName()))
            return new ResponseEntity("UserName Exists",HttpStatus.BAD_REQUEST);
        if(signUpRequest.getPassword().length() >= 6) return ResponseEntity.status(HttpStatus.OK).body(authService.registerUser(signUpRequest));
        else return new ResponseEntity("Minimum password six words",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
    }
}
