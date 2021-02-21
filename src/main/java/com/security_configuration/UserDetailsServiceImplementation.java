package com.security_configuration;

import com.models.User;
import com.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName).
                orElseThrow(()->new UsernameNotFoundException("UserName not found"));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                true,true,true,true,
                Collections.emptyList());
    }
}
