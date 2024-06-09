package org.example.reactweatherback.ApiServices;

import org.example.reactweatherback.ApiEntities.User;
import org.example.reactweatherback.ApiRepos.UserRepository;
import org.example.reactweatherback.ApiDtos.UserResponse;
import org.example.reactweatherback.User.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final UserService userService;

    public AdminService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();
        users.forEach((user -> responses.add(new UserResponse(user.getId(), user.getEmail(), user.getPassword(), user.getRole(), userService.getLocations(user.getId())))));
        return responses;
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void swapRoleById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return;

        Role role = user.getRole();
        if (role == Role.ADMIN) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.ADMIN);
        }
        userRepository.save(user);
    }
}
