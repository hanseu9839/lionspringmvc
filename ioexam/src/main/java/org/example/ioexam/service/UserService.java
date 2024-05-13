package org.example.ioexam.service;

import org.example.ioexam.domain.User;

public interface UserService {
    public void joinUser(User user); // 회원가입 메서드
    public User getUser(String email);
}
