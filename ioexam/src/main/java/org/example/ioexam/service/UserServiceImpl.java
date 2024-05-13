package org.example.ioexam.service;

import org.example.ioexam.dao.UserDao;
import org.example.ioexam.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        // 회원가입을 위한 비즈니스 코드가 작성되어야함..
        // 회원가입을 위한 비즈니스가 수행되면... 해당 데이터를 저장하는 코드가 실행
        userDao.addUser(user);
    }

    @Override
    public User getUser(String email) {

        return userDao.getUser(email);
    }
}
