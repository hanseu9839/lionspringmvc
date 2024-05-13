package org.example.ioexam.dao;

import org.example.ioexam.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;


//@Component
public class UserHanDaoImpl implements  UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+"의 정보를 CaramiDAO를 통해 잘 저장했습니다.");
    }
}
