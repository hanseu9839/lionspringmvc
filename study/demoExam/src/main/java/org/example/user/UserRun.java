package org.example.user;

import org.example.user.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserRun {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserRun.class, args);
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
    }
}
