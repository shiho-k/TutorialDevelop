package com.techacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

}
