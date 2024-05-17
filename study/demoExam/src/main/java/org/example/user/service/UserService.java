package org.example.user.service;


import org.example.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    void addUser(User user);
}
