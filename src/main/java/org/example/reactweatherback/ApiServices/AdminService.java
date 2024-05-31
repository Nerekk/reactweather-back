package org.example.reactweatherback.ApiServices;

import org.example.reactweatherback.ApiEntities.User;
import org.example.reactweatherback.ApiRepos.UserRepository;
import org.example.reactweatherback.ApiDtos.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();
        users.forEach((user -> responses.add(new UserResponse(user.getId(), user.getEmail(), user.getPassword()))));
        return responses;
    }
}
