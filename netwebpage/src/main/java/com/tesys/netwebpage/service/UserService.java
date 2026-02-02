package com.tesys.netwebpage.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tesys.netwebpage.model.User;
import com.tesys.netwebpage.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String rawPassword) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole("ROLE_USER");

        return userRepository.save(user);
    }
}
