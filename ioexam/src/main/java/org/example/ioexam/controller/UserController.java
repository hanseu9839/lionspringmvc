package org.example.ioexam.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.ioexam.domain.User;
import org.example.ioexam.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    @PostConstruct
    public void init() {
        System.out.println("postConstruct 실행!!");
    }


    @PreDestroy
    public void destory() {
        System.out.println("preDestory 실행!!");
    }

    public UserController(UserService userService) {
        System.out.println("UserController 생성자 호출!!");
        this.userService = userService;
    }

    public void joinUser() {
        // 실제 동작할 때는 사용자로부터 정보를 받아온다.
        User user = new User();
        user.setName("한승균");
        user.setEmail("hans9839@naver.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }

    public void getUser(){
        String email = "hans9839@naver.com";

        userService.getUser(email);
    }
}
