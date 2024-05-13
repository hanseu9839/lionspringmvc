package org.example.ioexam.config;

import org.example.ioexam.controller.UserController;
import org.example.ioexam.dao.UserDao;
import org.example.ioexam.dao.UserDaoImpl;
import org.example.ioexam.service.UserService;
import org.example.ioexam.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages="org..example.ioexam")
public class UserConfig {
    // IOC 컨테이너에 Bean을 동락하는 방법을 생각해보고 동작 할 수 있도록 작성해주세요.
    // 1. JavaConfig를 이용해서 동작하도록!!

//    @Bean
//    public UserDao userDao(){
//        return new UserDaoImpl();
//    }
//
//    @Bean
//    public UserService userService(UserDao userDao){
//        return new UserServiceImpl(userDao);
//    }
//
//    @Bean
//    public UserController userController(UserServiceImpl userService){
//        return new UserController(userService);
//    }

    // 2. component scan 동작되도록 살펴보세요..
    // 2-1 누가 컴포넌트인지 알려줘야함.
    // 2-2 componentScan을 추가한다.
}
