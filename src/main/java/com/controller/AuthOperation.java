package com.controller;

import com.dto.AuthenticationResponse;
import com.dto.LoginRequest;
import com.dto.SignUpRequest;
import com.models.User;
import com.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthOperation{
    private AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@Valid @RequestBody SignUpRequest signUpRequest){
//         final String PATTERN= "(?=.*?[#?!@$%^&*-])";
//         final Pattern pattern = Pattern.compile(PATTERN);

        if(authService.ifUserExists(signUpRequest.getUserName()))
            return new ResponseEntity("UserName Exists",HttpStatus.BAD_REQUEST);

//        Matcher matcher= pattern.matcher(signUpRequest.getPassword());
//        if(!matcher.matches()) return new ResponseEntity("Symbol missing in password",HttpStatus.BAD_REQUEST);

        if(signUpRequest.getPassword().length() >= 6) return ResponseEntity.status(HttpStatus.OK).body(authService.registerUser(signUpRequest));
        else return new ResponseEntity("Minimum password six words",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
    }
}
