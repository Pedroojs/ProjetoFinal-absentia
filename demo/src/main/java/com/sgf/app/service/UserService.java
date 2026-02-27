package com.sgf.app.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sgf.app.repository.UserRepository;
import com.sgf.app.model.User;
import com.sgf.app.model.Role;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User register(String email, String username, String password) {

        User user = new User(
                email,
                encoder.encode(password),
                username,
                Role.ROLE_USER
        );

        return repository.save(user);
    }

    @Override
    public User loadUserByUsername(String email) {
        return repository.findByEmail(email)
                .orElseThrow();
    }
}