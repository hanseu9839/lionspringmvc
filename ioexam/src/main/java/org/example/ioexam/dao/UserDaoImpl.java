package org.example.ioexam.dao;

import org.example.ioexam.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class UserDaoImpl implements UserDao{
    Map<String , User> users= new HashMap<>();

    @Override
    public User getUser(String email) {
        User user = null;
        if(!users.containsKey(email)){
            System.out.println("해당 이메일의 유저 정보는 없습니다.");
            return null;
        } else {
            System.out.println(users.containsKey(email));
            user = users.get(email);
            System.out.println(user);
            return user;
        }

    }

    @Override
    public List<User> getUsers() {
        return users.values().stream().toList();
    }

    @Override
    public void addUser(User user) {
        users.put(user.getEmail() , user);
        System.out.println(user+ "의 정보가 잘 저장 되었습니다.");
    }
}
