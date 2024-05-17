package org.example.user.dao;

import org.example.user.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Component
public class UserDaoImpl implements  UserDao{
    long id = 1L;
    Map<Long, User> map = new HashMap<>();

    @Override
    public void userAdd(User user) {
        map.put(id++, user);
        System.out.println(user+"의 정보가 잘 저장되었습니다.");
    }

}
