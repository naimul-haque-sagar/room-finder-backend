package com.service;

import com.dto.AuthenticationResponse;
import com.dto.LoginRequest;
import com.dto.SignUpRequest;
import com.jwt.JwtProvider;
import com.models.User;
import com.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(SignUpRequest signUpRequest) {
        User user=new User();
        user.setUserName(signUpRequest.getUserName());
        user.setPassword(encodePassword(signUpRequest.getPassword()));
        return userRepository.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String authenticationToken=jwtProvider.generateToken(authentication);
        return new AuthenticationResponse(authenticationToken,loginRequest.getUserName());
    }

    public boolean ifUserExists(String userName) {
        return userRepository.existsByUserName(userName);
    }
}
