package org.example.user.controller;

import org.example.user.domain.User;
import org.example.user.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setName("ttt");
        userService.addUser(user);
    }
}
